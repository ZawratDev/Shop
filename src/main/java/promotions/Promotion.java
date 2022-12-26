package promotions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Promotion {
    private static final Logger LOGGER = LogManager.getLogger(Promotion.class);
    private static final HashMap<String, Double> PROMOTION_CODES = new HashMap<>();

    public Promotion() {
        PROMOTION_CODES.put("CODE10", 0.10);
        PROMOTION_CODES.put("CODE15", 0.15);
        PROMOTION_CODES.put("CODE20", 0.20);
        PROMOTION_CODES.put("CODE25", 0.25);
        PROMOTION_CODES.put("CODE30", 0.30);
        PROMOTION_CODES.put("CODE35", 0.35);
        PROMOTION_CODES.put("CODE40", 0.40);
    }
    protected HashMap<String, Double> getPromotionCodes(){
        return PROMOTION_CODES;
    }
}
