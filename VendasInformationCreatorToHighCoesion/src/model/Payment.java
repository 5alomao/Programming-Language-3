package model;

public abstract class Payment {
	
	private String name;
	private double fees;
	private double discount;
	
	public abstract double getFinalPrice (double finalPrice);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}
	
	public void setFees(double fees) {
		this.fees = fees/100;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount/100;
	}
	
}
