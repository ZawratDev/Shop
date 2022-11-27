import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Delivery {
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);
    private static final HashMap<String, Double> DELIVERS = new HashMap<>();

    Delivery() {
        DELIVERS.put("InPost", 9.90);
        DELIVERS.put("UPS", 14.90);
        DELIVERS.put("DHL", 15.90);
        DELIVERS.put("DPD", 15.90);
        DELIVERS.put("Poczta Polska", 12.90);
        DELIVERS.put("Fedex", 16.99);
    }

    public HashMap<String, Double> getDelivers() {
        return DELIVERS;
    }

    public void showDelivers() {
        int deliverNumber = 0;
        for (String deliver : DELIVERS.keySet()) {
            deliverNumber++;
            System.out.println(deliverNumber + ". " + deliver + " - price: " + DELIVERS.get(deliver)+ " zl");
        }
    }
}
