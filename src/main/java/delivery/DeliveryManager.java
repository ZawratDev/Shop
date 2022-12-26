package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import transactions.Transaction;
import transactions.TransactionStatus;
import users.Address;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeliveryManager {
    private static final Logger logger = LogManager.getLogger(DeliveryManager.class);
    private static final Scanner scanner = new Scanner(System.in);


    public void checkDelivery(@NotNull Transaction transaction) throws DeliveryAddressExeption { //same name as DeliveryChecker method
        DeliveryChecker deliveryChecker = new DeliveryChecker();
        if (!deliveryChecker.checkDelivery(transaction.getUSER())) {
            throw new DeliveryAddressExeption();
        }
    }
    public Deliverer setUpDelivery(Address address) {
        logger.info("Initializing the DeliverersList constructor...");
        DeliverersList deliverersList = new DeliverersList();
        return chooseDelivery(deliverersList.getDELIVERERS_LIST(address));
    }

    public Deliverer chooseDelivery(LinkedList<Deliverer> deliverersList) {
        logger.info("Initializing choosing delivery...");
        logger.trace("Showing available deliverers");
        System.out.println("Please choose a deliverer:");
        showDeliverers(deliverersList);
        System.out.println("Type the number of chosen deliverer from the list: ");
        int userChoose = scanner.nextInt() - 1;
        scanner.nextLine(); // to unlock the scanner
        logger.info("User has chosen {} as the deliverer with the price = {}",
                deliverersList.get(userChoose)
                        .getName(),
                deliverersList.get(userChoose)
                        .getPrice());
        return deliverersList.get(userChoose);
    }
    private void showDeliverers(List<Deliverer> deliverersList) {
        int delivererNumber = 0;
        for (Deliverer deliverer : deliverersList) {
            delivererNumber++;
            System.out.println(delivererNumber + ". " + deliverer.getName() + " - price: " + deliverer.getPrice() + " zl");
        }
    }

}

