package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import payments.exceptions.PaymentFailure;
import transactions.Transaction;
import transactions.TransactionIdConstructor;


public class Payment {
	private static final Logger logger = LogManager.getLogger(Payment.class);
	private final int PAYMENT_ID;
	private PaymentStatus paymentStatus;
	private int transactionId;

	public Payment() {
		PAYMENT_ID = PaymentIdConstructor.setPaymentId();
		paymentStatus = PaymentStatus.NEW;
	}
	protected int getTransactionId() {
		return transactionId;
	}

	protected Payment setTransactionId(int transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	protected int getPAYMENT_ID() {
		return PAYMENT_ID;
	}
	protected PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	protected Payment setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
		return this;
	}

}

