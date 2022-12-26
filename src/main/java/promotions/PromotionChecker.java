package promotions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

public class PromotionChecker {
    private static final Logger logger = LogManager.getLogger(PromotionChecker.class);
    private static final double NO_DISCOUNT = 0;

    public double checkPromoCode(String code) {
        logger.debug("Checking if provided promotion code \"{}\" is valid", code);
        HashMap<String, Double> promotionCodes = new Promotion().getPromotionCodes();
        logger.debug("findPromotionCode in Promotion is running...");
        logger.trace("PROMOTION_CODES.keySet(): {}", promotionCodes.keySet());

        for (String promoCode : promotionCodes.keySet()) {
            logger.debug("findPromotionCode -> promoCode: {}", promoCode);
            if (code.equals(promoCode)) {
                logger.info("User promotion code: {} exists. Code from the list: {}", code, promoCode);
                logger.trace("Returning discount: {}", promotionCodes.get(promoCode));
                return promotionCodes.get(promoCode);
            }
            else logger.warn("This code doesn't equal code {}", promoCode);
        }
        logger.info("Returning no discount!");
        return NO_DISCOUNT;
    }
}
