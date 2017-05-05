
public class Drink {
	private String name, manufacturer;
	private int quantity, price;

	Drink(String name, String manufacturer, int quantity, int price) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
	}

	void setName(String name) {
		this.name = name;
	}

	void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	void setPrice(int price) {
		this.price = price;
	}

	String getName() {
		return name;
	}

	String getManufacturer() {
		return manufacturer;
	}

	int getQuantity() {
		return quantity;
	}

	int getPrice() {
		return price;
	}
}
