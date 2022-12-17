package payments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentIdConstructor {
    private static final Logger LOGGER = LogManager.getLogger(PaymentIdConstructor.class);

    static int paymentId = 0;

    public int getPaymentId() {
        return paymentId;
    }
    public static int setPaymentId() {
        LOGGER.info("Generating payment ID...");
        return paymentId += 1;
    }
}
