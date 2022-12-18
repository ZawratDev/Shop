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

	private final int TRANSACTION_ID;
	private double sum;
	private double finalSum;
	private final double TOTAL_WEIGHT;
	private final User USER;
	private final Cart CART;
	private final int ITEM_COUNT;
//	private final Deliverer DELIVERER;
	private final double DELIVERY_COST;

	private boolean isPaid = false;


	public Transaction(Cart cart, String promoCode, User user) {
		LOGGER.info("Initializing Transaction Constructor...");
		TRANSACTION_ID = TransactionIdConstructor.setTransactionId();

		LOGGER.info("Creating new transaction #{} for user #{} and cart #{}", TRANSACTION_ID, user.getId(), cart.getId());
		this.USER = user;
		this.CART = cart;

		LOGGER.trace("Counting products in the cart");
		ITEM_COUNT = cart.productList.size();
		LOGGER.info("Product count {}", ITEM_COUNT);

		System.out.println("Please choose a way of delivery: ");
		DELIVERY_COST = getDELIVERER()
				.getPrice();
		LOGGER.info("The chosen delivery cost: {}", DELIVERY_COST);

		ArrayList<Product> productList = cart.productList;
		LOGGER.info("Initializing a calculation of the sum amount");
		sum = calculateSum(productList, DELIVERY_COST);

		LOGGER.info("Initializing a calculation of the products total weight");
		TOTAL_WEIGHT = calculateWeight(productList);

		LOGGER.trace("Initializing a calculation of the totalSum after discount...");
		finalSum = calculateDiscount(sum, promoCode);
		LOGGER.info("The final sum after discount: {}", finalSum);
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

	private Deliverer getDELIVERER() {
		LOGGER.info("Checking if the user has a shipping address.");

		if (!USER.getDeliveryAddress()
				.isCorrectAddressExist()) {
			LOGGER.info("Initializing setAddressWizard at-hoc!");
			System.out.println("We don't have your correct shipping address. Please provide it now: ");
			USER.setDeliveryAddress();
		}

		LOGGER.trace("Running calculateDeliveryCost...");
		Delivery delivery = new Delivery(USER.getDeliveryAddress());
		return delivery.chooseDelivery();
	}

	public double getFinalSum() {
		return finalSum;
	}

	public double getTOTAL_WEIGHT() {
		return TOTAL_WEIGHT;
	}

	public int getITEM_COUNT() {
		return ITEM_COUNT;
	}

	public Cart getCART() {
		return CART;
	}

	public User getUSER() {
		return USER;
	}

	public int getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}

	public void setIsPaid(boolean isPaid) {
		LOGGER.info("Setting transaction status to: {}", isPaid);
		this.isPaid = isPaid;
	}
}
