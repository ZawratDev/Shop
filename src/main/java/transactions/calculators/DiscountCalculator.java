package transactions.calculators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiscountCalculator {
    private static final Logger logger = LogManager.getLogger(DiscountCalculator.class);
    protected double useDiscount(double sum, double discount) {
        logger.trace("Activating the discount {} to the sum {}", discount, sum);
        return sum * (1-discount);
    }

}
