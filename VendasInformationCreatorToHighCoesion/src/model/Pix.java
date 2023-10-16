package model;

public class Pix extends Payment{

	public Pix() {
		setName("Pix");
		setFees(0);
		setDiscount(5);
	}
	
	@Override
	public double getFinalPrice(double finalPrice) {
		return finalPrice - (finalPrice * this.getDiscount());
	}
}
