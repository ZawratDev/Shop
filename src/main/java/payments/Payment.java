package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transactions.Transaction;

public class Payment {
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    double transactionSum;
    int userId;
    public Payment(Transaction transaction) {
        LOGGER.info("Initializing Payment Constructor...");

        transactionSum = transaction.getFinalSum();
        userId = transaction.getUSER_HOLDER()
                .getId();
    }
}
