package products;

public class ProductIdConstructor {
    static int productId = 0;

    public int getProductId() {
        return productId;
    }

    public static int setProductId() {
        return productId += 1;
    }
}
