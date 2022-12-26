package transactions.exceptions;

import transactions.Transaction;
import transactions.TransactionStatus;

public class TransactionInWrongState extends Exception {
    private final int transactionId;
    private final TransactionStatus transactionStatus;
    private TransactionStatus expectedTransactionStatus = null;

    public TransactionInWrongState(Transaction transaction, TransactionStatus expectedTransactionStatus) {
        this.transactionId = transaction.getTRANSACTION_ID();
        this.transactionStatus = transaction.getStatus();
        this.expectedTransactionStatus = expectedTransactionStatus;
    }
    public TransactionInWrongState(Transaction transaction) {
        this.transactionId = transaction.getTRANSACTION_ID();
        this.transactionStatus = transaction.getStatus();
    }
    @Override
    public String toString() {
        return "\nError details: \n" +
                "Transaction status is unexpected. \n" +
                "transactionId: " + transactionId +", \n" +
                "transactionStatus: " + transactionStatus +
                "expectedTransactionStatus: " + expectedTransactionStatus;
    }
}
