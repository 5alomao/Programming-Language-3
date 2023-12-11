package model;

public class LeafProduct implements ComponentProduct {

	private double price;

	public LeafProduct(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}


