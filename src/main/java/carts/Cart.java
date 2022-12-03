package carts;

import products.Product;
import users.User;

import java.util.ArrayList;

public class Cart {

    private final int id;
    private final User user;
    private boolean isPaid; // for the future check if the cart is already paid or not.
    public ArrayList<Product> productList = new ArrayList<>();

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
