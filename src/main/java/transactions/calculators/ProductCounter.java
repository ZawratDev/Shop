package transactions.calculators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import carts.Cart;
public class ProductCounter {
    private static final Logger logger = LogManager.getLogger(ProductCounter.class);

    public static int countProductsInTheCart(Cart cart) {
        logger.info("Counting products in the cart...");
        return cart.getProductList().size();
    }
}
