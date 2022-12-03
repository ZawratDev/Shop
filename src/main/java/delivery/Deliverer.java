package delivery;

public class Deliverer {
private final String name;
private final Double price;
private final boolean international;

	Deliverer(String name, Double price, boolean isInternational) {
		this.name = name;
		this.price = price;
		international = isInternational;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public boolean isInternational() {
		return international;
	}
}
