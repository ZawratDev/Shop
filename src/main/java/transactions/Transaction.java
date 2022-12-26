package transactions;

import carts.Cart;
import delivery.Deliverer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import users.User;

public class Transaction {
	private static final Logger logger = LogManager.getLogger(Transaction.class);

	private final int TRANSACTION_ID;
	private double productSumAmount;
	private double productSumAmountWithDelivery;
	private double finalSum;
	private double discount;
	private double totalWeight;
	private final User USER;
	private final Cart CART;
	private int ITEM_COUNT;
	private TransactionStatus status;
	private boolean isPaid = false;
	private Deliverer deliverer;
	private double deliveryCost;


	public Transaction() {
		TRANSACTION_ID = TransactionIdConstructor.setTransactionId();
		status = TransactionStatus.NEW;
		this.USER = null;
		this.CART = null;
	}
	public Transaction(Cart cart, User user) {
		TRANSACTION_ID = TransactionIdConstructor.setTransactionId();
		status = TransactionStatus.NEW;
		this.CART = cart;
		this.USER = user;

	}

	public int getTRANSACTION_ID() {
		return TRANSACTION_ID;
	}

	public double getProductSumAmount() {
		return productSumAmount;
	}

	protected Transaction setProductSumAmount(double productSumAmount) {
		this.productSumAmount = productSumAmount;
		return this;
	}

	protected Transaction setFinalSum(double finalSum) {
		this.finalSum = finalSum;
		return this;
	}

	public double getFinalSum() {
		return finalSum;
	}

	public User getUSER() {
		return USER;
	}

	public Cart getCART() {
		return CART;
	}

	public int getITEM_COUNT() {
		return ITEM_COUNT;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public Deliverer getDeliverer() {
		return deliverer;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public double getProductSumAmountWithDelivery() {
		return productSumAmountWithDelivery;
	}

	public double getDiscount() {
		return discount;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public boolean isPaid() {
		return isPaid;
	}

	protected Transaction setITEM_COUNT(int itemCount) {
		ITEM_COUNT = itemCount;
		return this;
	}

	protected Transaction setStatus(TransactionStatus status) {
		this.status = status;
		return this;
	}

	protected Transaction setPaid(boolean paid) {
		isPaid = paid;
		return this;
	}

	protected Transaction setDeliverer(Deliverer deliverer) {
		this.deliverer = deliverer;
		return this;
	}

	protected Transaction setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
		return this;
	}

	protected Transaction setDiscount(double promotion) {
		logger.info("Setting a promotion to {}%", promotion*100);
		this.discount = promotion;
		return this;
	}

	public Transaction setProductSumAmountWithDelivery(double productSumAmountWithDelivery) {
		this.productSumAmountWithDelivery = productSumAmountWithDelivery;
		return this;
	}
}

//
	// logger.trace("Adding delivery costs...");
	// sum +=deliveryCost;
	// 	logger.info("Calculated total amount in the cart: {}",sum);
	// 	return sum;
	//




