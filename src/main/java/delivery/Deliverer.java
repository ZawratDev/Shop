package delivery;

public class Deliverer {
private final String name;
private final Double price;
	Deliverer(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
}
