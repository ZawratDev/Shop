import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Payment {
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    double transactionSum;
    int userId;
    Payment(Transaction transaction) {
        LOGGER.info("Initializing Payment Constructor...");

        transactionSum = transaction.getFinalSum();
        userId = transaction.getUserHolder()
                .getId();
    }
}
