package transactions.calculators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.Product;

import java.util.ArrayList;

public class WeightCalculator {
    private static final Logger logger = LogManager.getLogger(WeightCalculator.class);

    public double calculateWeight(ArrayList<Product> productList) {
        logger.trace("Calculating the weight of the products in the cart");
        double weight = 0;
        for (Product productWeight : productList) {
            weight += productWeight.getWeight();
            logger.trace("Summary weight after iteration: {}", weight);
        }
        logger.info("Calculated total weight of the products in the cart: {} ", weight);
        return weight;
    }
}
