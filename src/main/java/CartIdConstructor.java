public class CartIdConstructor {
    static int cartId = 0;

    public int getCartId() {
        return cartId;
    }
    public static int setCartId() {
        return cartId += 1;
    }
}
