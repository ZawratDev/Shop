import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;

public class Delivery {
	private static final Logger LOGGER = LogManager.getLogger(Delivery.class);
	private static final LinkedList<Deliverer> DELIVERS = new LinkedList<>();
	private static final Scanner SCANNER = new Scanner(System.in);

	Delivery() {
		LOGGER.info("Initializing Delivery constructor");

		Deliverer inpost = new Deliverer("INPOST", 9.90);
		Deliverer ups = new Deliverer("UPS", 14.90);
		Deliverer dhl = new Deliverer("DHL", 15.90);
		Deliverer dpd = new Deliverer("DPD", 16.00);
		Deliverer pocztaPolska = new Deliverer("POCZTA POLSKA", 12.90);
		Deliverer fedex = new Deliverer("FEDEX", 16.99);

		DELIVERS.add(inpost);
		DELIVERS.add(ups);
		DELIVERS.add(dhl);
		DELIVERS.add(dpd);
		DELIVERS.add(pocztaPolska);
		DELIVERS.add(fedex);
	}

	public Deliverer chooseDelivery() {
		int deliverNumber = 0;
		for (Deliverer deliverer : DELIVERS) {
			deliverNumber++;
			System.out.println(deliverNumber + ". " + deliverer.getName() + " - price: " + deliverer.getPrice() + " zl");
		}
		int userChoose = SCANNER.nextInt() - 1;
		SCANNER.nextLine(); //to unlock the scanner
		LOGGER.info("User has chosen {} as the deliverer with the price = {}", DELIVERS.get(userChoose).getName(), DELIVERS.get(userChoose).getPrice());
		return DELIVERS.get(userChoose);
	}
}
