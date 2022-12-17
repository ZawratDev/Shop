package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payments.exceptions.PaymentFailure;

import java.math.BigInteger;

public class MockPaymentProcess {
	private static final Logger LOGGER = LogManager.getLogger(MockPaymentProcess.class);

	public boolean pay(int paymentId, double transactionSum) {
		LOGGER.info("Checking if the payment was successful on the payment provider side.");
		LOGGER.debug("paymentId: {}", paymentId);
		LOGGER.debug("transactionSum: {}", transactionSum);
		LOGGER.debug("(paymentId > 0) && transactionSum > 0 -> {}", ((paymentId > 0) && transactionSum > 0));
		return (paymentId > 0) && transactionSum > 0;
	}
}
