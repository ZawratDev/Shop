public class Product {

    private final int id;
    private String name;
    private double price;
    private double weight;

    Product(String productName, double productPrice) {
        name = productName;
        price = productPrice;
        weight = -1;
        id = ProductIdConstructor.setProductId();
    }

    Product(String productName, double productPrice, double productWeight ) {
        name = productName;
        price = productPrice;
        weight = productWeight;
        id = ProductIdConstructor.setProductId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Product setWeight(double weight) {
        this.weight = weight;
        return this;
    }
}
