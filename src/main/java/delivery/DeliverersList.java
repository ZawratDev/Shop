package delivery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.Address;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class DeliverersList {

	private static final Logger logger = LogManager.getLogger(DeliverersList.class);
	private final LinkedList<Deliverer> DELIVERERS_LIST = new LinkedList<>();

	DeliverersList() {
		setDeliverersList();
	}

	private void setDeliverersList() {
		logger.info("Initializing setDeliverersList.");
		logger.trace("Creating new Deliverer instances.");
		Deliverer inpost = new Deliverer("INPOST", 9.90, false);
		Deliverer pocztaPolska = new Deliverer("POCZTA POLSKA", 12.90, false);
		Deliverer ups = new Deliverer("UPS", 14.90, true);
		Deliverer dhl = new Deliverer("DHL", 15.90, true);
		Deliverer dpd = new Deliverer("DPD", 16.00, true);
		Deliverer fedex = new Deliverer("FEDEX", 16.99, true);

		logger.trace("Adding Deliverer instances to the DELIVERERS_LIST.");
		DELIVERERS_LIST.add(inpost);
		DELIVERERS_LIST.add(ups);
		DELIVERERS_LIST.add(dhl);
		DELIVERERS_LIST.add(dpd);
		DELIVERERS_LIST.add(pocztaPolska);
		DELIVERERS_LIST.add(fedex);
		logger.info("A basic DELIVERERS_LIST is completed.");
	}
	protected LinkedList<Deliverer> getDELIVERERS_LIST() {
		logger.info("Initalizing getDELIVERERS_LIST without an argument. Returning basic list...");
		return DELIVERERS_LIST;
	}
	protected LinkedList<Deliverer> getDELIVERERS_LIST(Address deliveryAddress) { //maybe add here checker if the address is correct?
		boolean onlyInternational = !deliveryAddress.getCountry().equals("POLAND"); //change this hardcode to check if country is on the international list
		logger.info("Calling getDELIVERERS_LIST with onlyInternational argument = {}.", onlyInternational);

		if (onlyInternational) {
			logger.info("Setting up a new list of international deliverers...");
			return DELIVERERS_LIST.stream()
					.filter(Deliverer::isInternational)
					.collect(Collectors.toCollection(LinkedList::new)); //trochę nie rozumiem jak to działa, ale działa
		}
		logger.info("Returning basic list...");
		return DELIVERERS_LIST;

	}
}
