package users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
    private static final Logger LOGGER = LogManager.getLogger(User.class);
    private final int id;
    private final String name;
    private Address deliveryAddress;

    public User(int userId, String userName) {
        LOGGER.info("Initializing User constructor with userId {} and userName {}.", userId, userName);
        id = userId;
        name = userName;
//        deliveryAddress = new Address();
        deliveryAddress = new Address("POLAND", "Morenowa", 1, 12, "80-289"); // do testów
    }

    public void setDeliveryAddress() {
        LOGGER.info("Setting delivery address...");
        deliveryAddress = new Address().setAddressWizard();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
}
