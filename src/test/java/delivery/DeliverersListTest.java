package delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.Address;

import java.util.List;

public class DeliverersListTest {
	private static final Logger LOGGER = LogManager.getLogger(DeliverersListTest.class);
	static boolean isInternational = true;


	public static void main(String[] args) {
		LOGGER.info("Running DeliverersListTest...");
		Address notInternationalTestAddress = new Address("POLAND", "Kwiatowa", 1, "80-800");
		Address InternationalTestAddress = new Address("NOTPOLAND", "Kwiatowa", 1, "80-800");

		DeliverersList deliverersList = new DeliverersList();
		LOGGER.info("Calling getDELIVERERS_LIST for notInternationalDeliverers");
		List<Deliverer> notInternationalDeliverers = deliverersList.getDELIVERERS_LIST(notInternationalTestAddress);
		showDeliverers(notInternationalDeliverers);

		LOGGER.info("Calling getDELIVERERS_LIST for InternationalDeliverers");
		List<Deliverer> InternationalDeliverers = deliverersList.getDELIVERERS_LIST(InternationalTestAddress);
		showDeliverers(InternationalDeliverers);


		}
		private static void showDeliverers(List<Deliverer> deliverersList) {
			int delivererNumber = 0;
			LOGGER.info("Initializing showDeliverers...");
			LOGGER.trace("Initializing a for-loop to show the correct deliverers");
			for (Deliverer deliverer : deliverersList) {
				delivererNumber++;
				System.out.println(delivererNumber + ". " + deliverer.getName() + " - price: " + deliverer.getPrice() + " zl");
		}
	}
}
