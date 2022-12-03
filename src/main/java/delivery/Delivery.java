package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.Address;

import java.util.LinkedList;
import java.util.Scanner;

public class Delivery {
	private static final Logger LOGGER = LogManager.getLogger(Delivery.class);
	private static final LinkedList<Deliverer> DELIVERERS = new LinkedList<>();
	private static final Scanner SCANNER = new Scanner(System.in);

	public Delivery() {
		LOGGER.info("Initializing Delivery constructor");

		Deliverer inpost = new Deliverer("INPOST", 9.90, false);
		Deliverer pocztaPolska = new Deliverer("POCZTA POLSKA", 12.90, false);
		Deliverer ups = new Deliverer("UPS", 14.90, true);
		Deliverer dhl = new Deliverer("DHL", 15.90, true);
		Deliverer dpd = new Deliverer("DPD", 16.00, true);
		Deliverer fedex = new Deliverer("FEDEX", 16.99, true);

		DELIVERERS.add(inpost);
		DELIVERERS.add(ups);
		DELIVERERS.add(dhl);
		DELIVERERS.add(dpd);
		DELIVERERS.add(pocztaPolska);
		DELIVERERS.add(fedex);
	}

	public Deliverer chooseDelivery(Address deliveryAddress) {
		LOGGER.info("Initializing choosing delivery...");
		LOGGER.trace("Checking if international deliverer is needed.");
		var deliverersToRemove = showDeliverers(!deliveryAddress.getCountry().equals("Poland"));
		for (Deliverer removedDeliverers : deliverersToRemove) {
			LOGGER.warn("Deleting {} from the DELIVERERS linkedList!", removedDeliverers.getName());
			DELIVERERS.remove(removedDeliverers);
		}

		int userChoose = SCANNER.nextInt() - 1;
		SCANNER.nextLine(); //to unlock the scanner
		LOGGER.info("User has chosen {} as the deliverer with the price = {}", DELIVERERS.get(userChoose).getName(), DELIVERERS.get(userChoose).getPrice());
		return DELIVERERS.get(userChoose);
	}

	private LinkedList<Deliverer> showDeliverers(boolean onlyInternational) {
		LOGGER.info("Showing deliverers...");
		LOGGER.info("Has to be onlyInternational: {}", onlyInternational);

		LinkedList<Deliverer> skippedDeliverers = new LinkedList<>(); //to monitor deliverers that cannot be chosen

		int delivererNumber = 0;
		for (Deliverer deliverer : DELIVERERS) {
			if (onlyInternational && !deliverer.isInternational()) {
				LOGGER.debug("Skipping deliverer {} due to not being international...", deliverer.getName());
				LOGGER.debug("Adding the {} to the skippedDeliverers lists.", deliverer.getName());
				skippedDeliverers.add(deliverer);
				continue;
			}
			delivererNumber++;
			System.out.println(delivererNumber + ". " + deliverer.getName() + " - price: " + deliverer.getPrice() + " zl");
		}
		return skippedDeliverers;
	}
}
