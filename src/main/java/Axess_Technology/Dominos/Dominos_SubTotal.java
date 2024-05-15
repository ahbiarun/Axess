package Axess_Technology.Dominos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dominos_SubTotal {
	private Map<String, Double> productPrices;
	private Map<String, Integer> productQuantities;

	public Dominos_SubTotal() {
		productPrices = new HashMap<>();
		productQuantities = new HashMap<>();
	}

	// Method to add a product with its price and quantity to the cart
	public void addProduct(String productName, double price, int quantity) {
		productPrices.put(productName, price);
		productQuantities.put(productName, quantity);
	}
	


	// Method to calculate the subtotal of the cart
	public double calculateSubtotal() {
		double subtotal = 0;
		for (String productName : productPrices.keySet()) {
			double price = productPrices.get(productName);
			int quantity = productQuantities.get(productName);
			subtotal += price * quantity;
		}
		return subtotal;
	}

	
	public void assertCartSubtotal(double expectedSubtotal) {
		double actualSubtotal = calculateSubtotal();
		if (actualSubtotal == expectedSubtotal) {
			System.out.println("Cart subtotal matches the expected subtotal: " + expectedSubtotal);
		} else {
			System.out.println("Cart subtotal does not match the expected subtotal:");
			System.out.println("Expected subtotal: " + expectedSubtotal);
			System.out.println("Actual subtotal: " + actualSubtotal);
		}
	}

}
