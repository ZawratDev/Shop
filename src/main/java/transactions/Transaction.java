package transactions;

import carts.Cart;
import delivery.Deliverer;
import delivery.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.Product;
import promotions.Promotion;
import users.User;

import java.util.ArrayList;

public class Transaction {
	private static final Logger LOGGER = LogManager.getLogger(Transaction.class);
	private double sum;
	private double finalSum;
	private final double totalWeight;
	private final User userHolder;
	private final Cart cartHolder;
	private final int count;

	public Transaction(Cart cart, String promoCode, User user) {
		LOGGER.info("Initializing Transaction Constructor...");

		userHolder = user;
		cartHolder = cart;

		LOGGER.trace("Counting products in the cart");
		count = cart.productList.size();
		LOGGER.info("product.Product count {}", count);

		System.out.println("Please choose a way of delivery: ");
		Deliverer deliverer = getDeliverer();
		double deliveryCost = deliverer.getPrice();
		LOGGER.info("The chosen delivery cost: {}", deliveryCost);

		ArrayList<Product> productList = cart.productList;
		LOGGER.trace("Initializing a calculation of the sum amount");
		sum = calculateSum(productList, deliveryCost);

		LOGGER.trace("Initializing a calculation of the products total weight");
		totalWeight = calculateWeight(productList);

		LOGGER.trace("Initializing a calculation of the totalSum after discount...");
		double discountedSum = calculateDiscount(sum, promoCode);
		LOGGER.info("The final sum after discount: {}", discountedSum);
	}

	private double calculateSum(ArrayList<Product> productList, double deliveryCost) {
		LOGGER.trace("Calculating the amount from the products in the cart");
		sum = 0;
		for (Product productPrice : productList) {
			sum += productPrice.getPrice();
			LOGGER.trace("Sum amount after iteration: {}", sum);
		}

		LOGGER.trace("Adding delivery costs...");
		sum += deliveryCost;
		LOGGER.info("Calculated total amount in the cart: {}", sum);
		return sum;
	}

	private double calculateWeight(ArrayList<Product> productList) {
		LOGGER.trace("Calculating the weight of the products in the cart");
		double weight = 0;
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

	private Deliverer getDeliverer() {
		LOGGER.trace("Running calculateDeliveryCost...");
		Delivery delivery = new Delivery();
		return delivery.chooseDelivery();
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

	public Cart getCartHolder() {
		return cartHolder;
	}

	public User getUserHolder() {
		return userHolder;
	}
}
