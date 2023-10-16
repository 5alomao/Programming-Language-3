package model;

public class Credit extends Payment{

	public Credit() {
		setName("Cartão de Crédito");
		setFees(5);
		setDiscount(0);
	}
	
	@Override
	public double getFinalPrice(double finalPrice) {
		return finalPrice + (finalPrice * this.getFees());
	}
}
