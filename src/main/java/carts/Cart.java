package carts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.Product;
import transactions.TransactionService;
import users.User;

import java.util.ArrayList;

public class Cart {
    private static final Logger logger = LogManager.getLogger(Cart.class);

    private final int id;
    private final User user;
    private boolean isPaid; // for the future check if the cart is already paid or not.
    private ArrayList<Product> productList = new ArrayList<>();
    private double promotionPercent;


    public Cart(User activeUser) {
        user = activeUser;
        id = CartIdConstructor.setCartId();
        isPaid = false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Cart addProductToCart(Product product) {
        productList.add(product);
        return this;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setPaid() {
        isPaid = true;
    }
}
