package transactions;

import delivery.DeliveryAddressExeption;
import delivery.DeliveryManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import promotions.PromotionManager;
import transactions.calculators.CalculatorsManager;
import transactions.calculators.ProductCounter;


public class TransactionService {
	private static final Logger logger = LogManager.getLogger(TransactionService.class);

	public Transaction start(Transaction transaction) {
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
		return transaction.setTotalWeight(calculatorsManager.calculateWeight(transaction))
				.setProductSumAmount(calculatorsManager.calculateSumAmountOfProducts(transaction))
				.setProductSumAmountWithDelivery(calculatorsManager.calculateSumAmountWithDelivery(transaction))
				.setFinalSum(calculatorsManager.calculateSumWithDiscount(transaction));
	}
}