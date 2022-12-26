package transactions.calculators;

import delivery.Deliverer;
import products.Product;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumCalculator {
    private static final Logger logger = LogManager.getLogger(SumCalculator.class);

    public double calculateSumOfProducts(ArrayList<Product> productList, double deliveryCost) {
        logger.info("Calculating the amount from the products in the cart");
        int sum = 0;
        for (Product productPrice : productList) {
            sum += productPrice.getPrice();
            logger.trace("Sum amount after iteration: {}", sum);
        }
        return sum;
    }
    public double addDeliveryCost(double productSum, double deliveryCost) {
        logger.trace("Adding a delivery cost to the sum amount of products: {}", productSum + deliveryCost);
        return productSum + deliveryCost;
    }
}

