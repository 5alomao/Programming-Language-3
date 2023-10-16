package model;

public class Debit extends Payment{

	public Debit() {
		setName("Cartão de Débito");
		setFees(0);
		setDiscount(0);
	}
	
	@Override
	public double getFinalPrice(double finalPrice) {
		return finalPrice;
	}
}
