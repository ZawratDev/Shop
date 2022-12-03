package promotions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Promotion {
    private static final Logger LOGGER = LogManager.getLogger(Promotion.class);
    private static final HashMap<String, Double> PROMOTION_CODES = new HashMap<>();
    private static final double NO_DISCOUNT = 0;

    public Promotion() {
        PROMOTION_CODES.put("CODE10", 0.10);
        PROMOTION_CODES.put("CODE15", 0.15);
        PROMOTION_CODES.put("CODE20", 0.20);
        PROMOTION_CODES.put("CODE25", 0.25);
        PROMOTION_CODES.put("CODE30", 0.30);
        PROMOTION_CODES.put("CODE35", 0.35);
        PROMOTION_CODES.put("CODE40", 0.40);
    }

    public double findPromotionCode(String code) {
        LOGGER.debug("findPromotionCode in Promotion is running...");
        LOGGER.trace("PROMOTION_CODES.keySet(): {}", PROMOTION_CODES.keySet());

        for (String promoCode : PROMOTION_CODES.keySet()) {
            LOGGER.debug("findPromotionCode -> promoCode: {}", promoCode);
            if (code.equals(promoCode)) {
                LOGGER.info("User promotion code: {} exists. Code from the list: {}", code, promoCode);
                LOGGER.trace("Returning discount: {}", PROMOTION_CODES.get(promoCode));
                return PROMOTION_CODES.get(promoCode);
            }
            else LOGGER.warn("This code doesn't equal code {}", promoCode);
        }
        LOGGER.info("Returning no discount!");
        return NO_DISCOUNT;
    }
}
