package users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
    private static final Logger LOGGER = LogManager.getLogger(User.class);
    private final int id;
    private final String name;
    private Address deliveryAddress;

    public User(int userId, String userName, Address address) {
        id = userId;
        name = userName;
        deliveryAddress = address;
    }
    public User(int userId, String userName) {
        id = userId;
        name = userName;
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
