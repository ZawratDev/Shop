package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.User;

public class DeliveryChecker {
    private static final Logger logger = LogManager.getLogger(DeliveryChecker.class);


    protected boolean checkDelivery(User user) { // nazwa do zmiany
        logger.info("Checking if the user has a shipping address.");

        if (!user.getDeliveryAddress()
                .isCorrectAddressExist()) {
            logger.info("Initializing setAddressWizard at-hoc!");
            System.out.println("We don't have your correct shipping address. Please provide it now: ");
            user.setDeliveryAddress();
        }
        return user.getDeliveryAddress().isCorrectAddressExist();
    }
}
