package model;

public class Product {

	private String name;
	private double costPrice;

	public Product(String name, double priceCost) {
		this.name = name;
		this.costPrice = priceCost;
	}

	public double getCostPrice() {
		return this.costPrice;
	}
	
	public String getName() {
		return this.name;
	}
	
}
