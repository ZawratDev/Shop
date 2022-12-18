package transactions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionIdConstructor {
    private static final Logger LOGGER = LogManager.getLogger(TransactionIdConstructor.class);

    static int transactionId = 0;

    public int getTransactionId() {
        return transactionId;
    }
    public static int setTransactionId() {
        LOGGER.info("Generating transaction ID...");
        return transactionId += 1;
    }
}
