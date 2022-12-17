package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.Address;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Delivery {
	private static final Logger LOGGER = LogManager.getLogger(Delivery.class);
	private static final LinkedList<Deliverer> DELIVERERS = new LinkedList<>();
	private static final Scanner SCANNER = new Scanner(System.in);
	private final LinkedList<Deliverer> deliverersList;
	public Delivery(Address deliveryAddress) {
		LOGGER.info("Initializing Delivery constructor...");
		DeliverersList fullDeliverersList = new DeliverersList();
		deliverersList = fullDeliverersList.getDELIVERERS_LIST(deliveryAddress);

	}
	public Deliverer chooseDelivery() {
		LOGGER.info("Initializing choosing delivery...");
		showDeliverers(deliverersList);
		int userChoose = SCANNER.nextInt() - 1;
		SCANNER.nextLine(); //to unlock the scanner
		LOGGER.info("User has chosen {} as the deliverer with the price = {}", deliverersList.get(userChoose).getName(), deliverersList.get(userChoose).getPrice());
		return deliverersList.get(userChoose);
	}

	private void showDeliverers(List<Deliverer> deliverersList) {
		LOGGER.info("Showing deliverers...");
			int delivererNumber = 0;
			LOGGER.trace("Initializing a for-loop to show the correct deliverers");
			for (Deliverer deliverer : deliverersList) {
				delivererNumber++;
				System.out.println(delivererNumber + ". " + deliverer.getName() + " - price: " + deliverer.getPrice() + " zl");
			}
	}
}
