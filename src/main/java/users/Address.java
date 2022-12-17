package users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Address {
	private static final Logger LOGGER = LogManager.getLogger(Address.class);
	private static final Scanner scanner = new Scanner(System.in);
	private String street;
	private String country;
	private String postCode;
	private Integer houseNumber;
	private Integer apartmentNumber;

	public Address() {
		street = "Unknown";
		country = "Unknown";
		postCode = "Unknown";
		houseNumber = null;
		apartmentNumber = null;
	}

	public Address(String country, String street, Integer houseNumber, String postCode) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.country = country;
		apartmentNumber = null;
	}

	Address(String country, String street, Integer houseNumber, Integer apartmentNumber, String postCode) {
		this.country = country;
		this.street = street;
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.apartmentNumber = apartmentNumber;
	}

	public Address setAddressWizard() {
		System.out.println("Please provide your address below:");

		System.out.println("Country: ");
		setCountry(scanner.nextLine().toUpperCase());

		System.out.println("street: ");
		setStreet(scanner.nextLine());

		System.out.println("houseNumber: ");
		setHouseNumber(scanner.nextInt());
		setStreet(scanner.nextLine());

		System.out.println("apartmentNumber (type \"0\" if there is none): ");
		setApartmentNumber(scanner.nextInt());
		setStreet(scanner.nextLine());

		System.out.println("postCode: ");
		setPostCode(scanner.nextLine());
		return this;
	}

	public boolean isCorrectAddressExist() {
		LOGGER.info("Initializing address checker...");

		if (!country.equals("Unknown") && !street.equals("Unknown") && !postCode.equals("Unknown") && houseNumber != null) {
			LOGGER.info("User's shipping address is correct.");
			return true;
		}
		LOGGER.info("User's shipping address is not correct.");
		return false;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		if (!(houseNumber < 2000)) {
			System.out.println("You've provided incorrect house number.");
		} else this.houseNumber = houseNumber;
	}

	public Integer getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
		if (!(apartmentNumber < 10000)) {
			System.out.println("You've provided incorrect apartmentNumber number.");
			this.apartmentNumber = apartmentNumber;
		}
	}
}

