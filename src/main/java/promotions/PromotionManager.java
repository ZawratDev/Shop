package promotions;

import carts.Cart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import transactions.Transaction;

import java.util.Scanner;

public class PromotionManager {
    private static final Logger logger = LogManager.getLogger(PromotionManager.class);
    private static final Scanner scanner = new Scanner(System.in);

    public double runPromotionServiceForTransaction(Transaction transaction){
        logger.info("Running Promotion Service...");
        PromotionChecker promotionChecker = new PromotionChecker();
        PromotionGetter promotionGetter = new PromotionGetter();
        return promotionChecker
                .checkPromoCode(promotionGetter
                        .getPromotionCode()); //Probably it isn't easy to read. Should I refactor this?
    }
}
