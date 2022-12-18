package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import payments.exceptions.PaymentFailure;
import transactions.Transaction;
import transactions.TransactionIdConstructor;


public class Payment {
	private static final Logger LOGGER = LogManager.getLogger(Payment.class);
	private final int PAYMENT_ID;
	private final boolean PAYMENT_STATUS;

	public Payment(@NotNull Transaction transaction) {
		LOGGER.info("Initializing Payment Constructor...");
		PAYMENT_ID = PaymentIdConstructor.setPaymentId();
		LOGGER.info("Creating new payment #{} for transaction #{} with total sum of {}.", PAYMENT_ID, transaction.getTRANSACTION_ID(), transaction.getFinalSum());


		PAYMENT_STATUS = redirectToPaymentProvider(PAYMENT_ID, transaction.getFinalSum());
		LOGGER.info("paymentStatus stored: {}", PAYMENT_STATUS);

		LOGGER.info("Sending Transaction #{} the payment #{} status ({})", transaction.getTRANSACTION_ID(), PAYMENT_ID, PAYMENT_STATUS);
		transaction.setIsPaid(PAYMENT_STATUS);

	}

	private boolean redirectToPaymentProvider(int paymentId, double transactionSum) {
		LOGGER.info("Initializing redirectToPaymentProvider...");
		MockPaymentProcess partnerPaymentProcess = new MockPaymentProcess();

		try {
			if (!partnerPaymentProcess.pay(paymentId, transactionSum)) {
				throw new PaymentFailure(paymentId, transactionSum);
			}
			LOGGER.info("Payment OK.");
			System.out.println("Your payment was successful. Thank you for your purchase!");
			return true;
		}
		catch (PaymentFailure e) {
			LOGGER.error("Payment failed! {}", e, e);
			System.out.println("The payment went wrong. Try again.");
			return false;
		}
	}
	public int getPAYMENT_ID() {
		return PAYMENT_ID;
	}
	public boolean getPAYMENT_STATUS() {
		return PAYMENT_STATUS;
	}
}

