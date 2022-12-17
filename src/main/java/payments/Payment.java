package payments;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payments.exceptions.PaymentFailure;
import transactions.Transaction;


public class Payment {
	private static final Logger LOGGER = LogManager.getLogger(Payment.class);
	private double transactionSum;
	private int userId;
	private final int paymentId;

	private boolean paymentStatus;

	public Payment(Transaction transaction) {
		LOGGER.info("Initializing Payment Constructor...");
		paymentId = PaymentIdConstructor.setPaymentId();
		LOGGER.debug("PaymentID: {}", paymentId);


		transactionSum = transaction.getFinalSum();
		userId = transaction.getUSER_HOLDER()
				.getId();
		try {
			int paymentIdTEST = 0;
			redirectToPaymentProvider(paymentIdTEST, transactionSum);
		}
		catch (RuntimeException e) {
			LOGGER.error("Error: ", e);
		}
	}

	private void redirectToPaymentProvider(int paymentId, double transactionSum) {
		MockPaymentProcess partnerPaymentProcess = new MockPaymentProcess();
		try {
			if (!partnerPaymentProcess.pay(paymentId, transactionSum)) {
				throw new PaymentFailure(paymentId, transactionSum);
			}
			System.out.println("Your payment was successful. Thank you for your purchase!");
			paymentStatus = true;
		}
		catch (PaymentFailure e) {
			LOGGER.error("Payment failed! {}", e, e);
			System.out.println("The payment went wrong. Try again.");
			paymentStatus = false;
		}
	}

	public int getPaymentId() {
		return paymentId;
	}
}

