import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment {
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    Payment(Transaction transaction, User user, Delivery deliver) {
        LOGGER.info("Initializing Payment Constructor...");
        double transactionSum = transaction.getFinalSum();
        int userId = user.getId();
    }



}
