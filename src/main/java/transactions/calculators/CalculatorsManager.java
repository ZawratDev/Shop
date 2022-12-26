package transactions.calculators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.Product;
import transactions.Transaction;

import java.util.ArrayList;

public class CalculatorsManager {
    private static final Logger logger = LogManager.getLogger(CalculatorsManager.class);

    public double calculateWeight(Transaction transaction) {
        logger.info("Initializing a total weight calculation of the products for transaction #{}", transaction.getTRANSACTION_ID());
        return new WeightCalculator()
                .calculateWeight(transaction.getCART().getProductList());
    }

    public double calculateWeight(ArrayList<Product> productList) {
        logger.info("Initializing a total weight calculation of the products");
        return new WeightCalculator()
                .calculateWeight(productList);
    }

    public double calculateSumAmountOfProducts(Transaction transaction) {
        logger.info("Initializing a sum calculation of the products");
        return new SumCalculator()
                .calculateSumOfProducts(transaction.getCART()
                        .getProductList(), transaction.getDeliverer()
                        .getPrice());
    }
    public double calculateSumAmountWithDelivery(Transaction transaction) {
        logger.info("Initializing a sum calculation of the products with a delivery");
        return new SumCalculator().addDeliveryCost(transaction.getProductSumAmount(),
                transaction.getDeliverer()
                        .getPrice());
    }
    public double calculateSumWithDiscount(Transaction transaction) {
        logger.info("Initializing a sum calculation using discount");
        return new DiscountCalculator().useDiscount(transaction.getProductSumAmountWithDelivery(), transaction.getDiscount());
    }
}