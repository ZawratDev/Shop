package products;

import java.util.List;

public class ProductList {
    public List<Product> getProductList() {
        return List.of(
                new Product("orange", 12, 0.3),
                new Product("banana", 8, 0.8),
                new Product("kiwi", 15, 0.2),
                new Product("apple", 9, 0.3)
        );
    }
}
