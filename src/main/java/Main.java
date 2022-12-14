import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {

        LOGGER.trace("Creating a user and a cart");
        User seller = new User(1, "Adam");
        Cart cart = new Cart(seller);

        System.out.println("Please provide a promotion code: ");
        String promoCode = SCANNER.nextLine();
        promoCode = promoCode.trim();


        Product apple = new Product("apple", 6, 0.2);
        Product orange = new Product("orange", 12, 0.3);
        Product banana = new Product("banana", 8, 0.8);
        Product kiwi = new Product("kiwi", 15, 0.2);

        cart.addProductToCart(apple).addProductToCart(orange).addProductToCart(banana).addProductToCart(kiwi);

        for (Product product : cart.getProductList()) {
            LOGGER.trace("Each product name from productList: {}", product.getName());
            LOGGER.trace("Each product ID productList: {}", product.getId());
        }

        LOGGER.info("Calling Transaction...");
        Transaction newTransaction = new Transaction(cart, promoCode, seller);

         LOGGER.info("Calling Payment...");
         Payment newPayment = new Payment(newTransaction);
    }
}
