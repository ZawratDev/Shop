package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.Address;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class DeliverersList {

	private static final Logger LOGGER = LogManager.getLogger(DeliverersList.class);
	private final LinkedList<Deliverer> DELIVERERS_LIST = new LinkedList<>();

	DeliverersList() {
		LOGGER.info("Initalizing the DeliverersList constructor...");
		setDeliverersList();
	}

	private void setDeliverersList() {
		LOGGER.info("Initalizing setDeliverersList.");
		LOGGER.trace("Creating new Deliverer instances.");
		Deliverer inpost = new Deliverer("INPOST", 9.90, false);
		Deliverer pocztaPolska = new Deliverer("POCZTA POLSKA", 12.90, false);
		Deliverer ups = new Deliverer("UPS", 14.90, true);
		Deliverer dhl = new Deliverer("DHL", 15.90, true);
		Deliverer dpd = new Deliverer("DPD", 16.00, true);
		Deliverer fedex = new Deliverer("FEDEX", 16.99, true);

		LOGGER.trace("Adding Deliverer instances to the DELIVERERS_LIST.");
		DELIVERERS_LIST.add(inpost);
		DELIVERERS_LIST.add(ups);
		DELIVERERS_LIST.add(dhl);
		DELIVERERS_LIST.add(dpd);
		DELIVERERS_LIST.add(pocztaPolska);
		DELIVERERS_LIST.add(fedex);
		LOGGER.info("A basic DELIVERERS_LIST is completed.");
	}
	public LinkedList<Deliverer> getDELIVERERS_LIST() {
		LOGGER.info("Initalizing getDELIVERERS_LIST without an argument. Returning basic list...");
		return DELIVERERS_LIST;
	}
	public LinkedList<Deliverer> getDELIVERERS_LIST(Address deliveryAddress) {
		boolean onlyInternational = !deliveryAddress.getCountry().equals("POLAND");
		LOGGER.info("Calling getDELIVERERS_LIST with onlyInternational argument = {}.", onlyInternational);

		if (onlyInternational) {
			LOGGER.info("Setting up a new list of international deliverers...");
			return DELIVERERS_LIST.stream()
					.filter(Deliverer::isInternational)
					.collect(Collectors.toCollection(LinkedList::new)); //trochę nie rozumiem jak to działa, ale działa
		}
		LOGGER.info("Returning basic list...");
		return DELIVERERS_LIST;

	}
}
