package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payments.exceptions.PaymentFailure;
import transactions.Transaction;

public class PaymentManager {
    private static final Logger logger = LogManager.getLogger(PaymentManager.class);
    private Payment payment;

    public PaymentManager createNewPayment() {
        payment = new Payment();
        return this;
    }
    public PaymentManager connectPaymentWithTransaction(int transactionId) {
        payment.setTransactionId(transactionId);
        return this;
    }
    public PaymentStatus redirectToPaymentProvider(double transactionSum) {
        logger.info("Initializing redirectToPaymentProvider...");

        MockPaymentProcess partnerPaymentProcess = new MockPaymentProcess();
        try {
            if (!partnerPaymentProcess.pay(payment.getPAYMENT_ID(), transactionSum)) {
                throw new PaymentFailure(payment.getPAYMENT_ID(), transactionSum);
            }
            logger.info("Payment #{} successful. Setting payment status to {}.",
                    getPaymentId(),
                    PaymentStatus.SUCCESS);
            System.out.println("Your payment was successful. Thank you for your purchase!");
            return payment.setPaymentStatus(PaymentStatus.SUCCESS).getPaymentStatus();
        }
        catch (PaymentFailure e) {
            logger.error("Payment #{} failed! Setting payment status to {}. {}",
                    getPaymentId(),
                    PaymentStatus.FAILED, e);
            System.out.println("The payment went wrong. Try again.");
            return payment.setPaymentStatus(PaymentStatus.FAILED).getPaymentStatus();
        }
    }
    public PaymentStatus getPaymentStatus() {
        return payment.getPaymentStatus();
    }
    public int getPaymentId() {
        return payment.getPAYMENT_ID();
    }
}
