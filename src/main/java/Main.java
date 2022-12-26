import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import carts.Cart;
import org.jetbrains.annotations.NotNull;
import payments.Payment;
import products.Product;
import products.ProductList;
import transactions.Transaction;
import transactions.TransactionService;
import users.Address;
import users.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        logger.info("Creating a user");
//        User seller = new User(1, "Adam");
        User seller = new User(1, "Adam", new Address("POLAND", "Morenowa", 1, 12, "80-289"));
        logger.info("User #{} has been created", seller.getId());

        logger.info("Creating a cart");
        Cart cart = new Cart(seller);
        logger.info("Cart #{} has been created for user #{}", cart.getId(), seller.getId());

        // cart.

        new ProductList()
                .getProductList()
                .forEach(cart::addProductToCart);


        for (Product product : cart.getProductList()) {
            logger.debug("Each product name from productList: {}", product.getName());
            logger.debug("Each product ID from productList: {}", product.getId());
        }

        logger.info("Initializing a new Transaction...");
        Transaction transaction = new Transaction(cart, seller);
        TransactionService transactionService = new TransactionService();
        transaction = transactionService.start(transaction);

        logger.info("Calling a new Payment for the Transaction #{}", transaction.getTRANSACTION_ID());
        // Payment newPayment = new Payment(transaction);
    }
}
