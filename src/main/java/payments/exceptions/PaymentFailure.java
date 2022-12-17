package payments.exceptions;

import payments.Payment;

public class PaymentFailure extends Exception {
	private final int paymentId;
	private final double transactionSum;

	public PaymentFailure(int paymentId, double transactionSum) {
		this.paymentId = paymentId;
		this.transactionSum = transactionSum;
	}

	@Override
	public String toString() {
		return "\nError details: \n" +
				"At least one of two parameters is < 0. \n" +
				"paymentId: " + paymentId +", \n" +
				"transactionSum: " + transactionSum;
	}
}
