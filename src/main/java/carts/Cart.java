package cart;

import java.util.ArrayList;

public class Cart {

    private final int id;
    private final User user;
    public ArrayList<Product> productList = new ArrayList<Product>();

    public Cart(User activeUser) {
        user = activeUser;
        id = CartIdConstructor.setCartId();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public Cart addProductToCart(Product product) {
        productList.add(product);
        return this;
    }
}
