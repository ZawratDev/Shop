import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Transaction {
    private static final Logger LOGGER = LogManager.getLogger(Transaction.class);
    double sum;
    double finalSum;
    double weight;
    double totalWeight;
    ArrayList<Product> productList;
    Delivery delivery;
    int count;

    Transaction(Cart cart, String promoCode, User user) {
        LOGGER.info("Initializing Transaction Constructor...");

        LOGGER.trace("Counting products in the cart");
        count = cart.productList.size();
        LOGGER.info("Product count {}", count);

        productList = cart.productList;
        LOGGER.trace("Initializing a calculation of the sum amount");
        sum = calculateSum(productList);

        LOGGER.trace("Initializing a calculation of the products total weight");
        totalWeight = calculateWeight(productList);

        LOGGER.trace("Initializing a calculation of the totalSum after discount...");
        finalSum = calculateDiscount(sum, promoCode);
        LOGGER.info("The final sum after discount: {}", finalSum);

        System.out.println("Please choose a way of delivery: ");
        delivery = new Delivery();
        delivery.showDelivers();
        // add an option for choosing the delivery.
    }

    private double calculateSum(ArrayList<Product> productList) {
        LOGGER.trace("Calculating the amount from the products in the cart");
        sum = 0;
        for (Product productPrice : productList) {
            sum += productPrice.getPrice();
            LOGGER.trace("Sum amount after iteration: {}", sum);
        }
        LOGGER.info("Calculated total amount in the cart: {}", sum);
        return sum;
    }

    private double calculateWeight(ArrayList<Product> productList) {
        LOGGER.trace("Calculating the weight of the products in the cart");
        weight = 0;
        for (Product productWeight : productList) {
            weight += productWeight.getWeight();
            LOGGER.trace("Summary weight after iteration: {}", weight);
        }
        LOGGER.info("Calculated total weight of the products in the cart: {} ", weight);
        return weight;
    }

    private double calculateDiscount(double sum, String userPromoCode) {
        LOGGER.trace("Running calculateDiscount...");
        Promotion promotion = new Promotion();

        double discount = promotion.findPromotionCode(userPromoCode);

        LOGGER.info("Discount: {}", discount);
        return sum * (1 - discount);
    }

    public double getFinalSum() {
        return finalSum;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getCount() {
        return count;
    }
}
