package transactions;

import carts.Cart;
import delivery.DeliveryAddressExeption;
import delivery.DeliveryManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payments.PaymentManager;
import payments.PaymentStatus;
import promotions.PromotionManager;
import transactions.calculators.CalculatorsManager;
import transactions.calculators.ProductCounter;
import transactions.exceptions.TransactionInWrongState;
import users.User;

import java.util.List;


public class TransactionService {
    private static final Logger logger = LogManager.getLogger(TransactionService.class);

    private Transaction transaction;

    public TransactionService createTransaction(Cart cart, User user) {
        transaction = new Transaction(cart, user);
        return this;
    }

    public TransactionService startTransactionProcessing(Transaction transaction) {
        transaction.setStatus(TransactionStatus.IN_PROGRESS);
        logger.info("Counting products in the cart");
        transaction.setITEM_COUNT(ProductCounter.countProductsInTheCart(transaction.getCART()));
        logger.info("Product count {}", transaction.getITEM_COUNT());

        logger.info("Collecting delivery information...");
        DeliveryManager deliveryManager = new DeliveryManager();
        try {
            deliveryManager.checkDelivery(transaction);
        } catch (DeliveryAddressExeption dae) {
            logger.error(dae);
            logger.error("The user has incorrect delivery address - setting the transaction status to {}", TransactionStatus.FAILED);
            transaction.setStatus(TransactionStatus.FAILED);
        }

        logger.info("Choosing a delivery");
        transaction.setDeliverer(deliveryManager.setUpDelivery(transaction
                .getUSER()
                .getDeliveryAddress()));

        logger.info("Asking user for a promotion code");
        transaction.setDiscount(new PromotionManager().runPromotionServiceForTransaction(transaction));

        logger.info("Initializing basic calculations...");
        CalculatorsManager calculatorsManager = new CalculatorsManager();
        transaction.setTotalWeight(calculatorsManager.calculateWeight(transaction))
                .setProductSumAmount(calculatorsManager.calculateSumAmountOfProducts(transaction))
                .setProductSumAmountWithDelivery(calculatorsManager.calculateSumAmountWithDelivery(transaction))
                .setFinalSum(calculatorsManager.calculateSumWithDiscount(transaction));
        return this;
    }

    public void startPayment(Transaction transaction) throws TransactionInWrongState {
        if (!(transaction.getStatus() == TransactionStatus.IN_PROGRESS)) {
            throw new TransactionInWrongState(transaction, TransactionStatus.IN_PROGRESS);
        }
        var paymentManager = new PaymentManager()
                .createNewPayment();
        transaction.setPaymentId(paymentManager
                .connectPaymentWithTransaction(transaction.getTRANSACTION_ID())
                .getPaymentId());
        paymentManager.redirectToPaymentProvider(transaction.getFinalSum());
        if (paymentManager.getPaymentStatus() == PaymentStatus.SUCCESS) {
            logger.info("Payment finished - setting transaction #{} status to {}.",
                    transaction.getTRANSACTION_ID(),
                    PaymentStatus.SUCCESS);
            transaction.setStatus(TransactionStatus.FINISHED);
        }
        if (paymentManager.getPaymentStatus() == PaymentStatus.FAILED) {
            logger.info("Payment unsuccessful - rolling back transaction #{} status to {}.",
                    transaction.getTRANSACTION_ID(),
                    PaymentStatus.NEW);
            transaction.setStatus(TransactionStatus.NEW);
        }
    }

    public Transaction getTransaction() {
        return transaction;
    }
}