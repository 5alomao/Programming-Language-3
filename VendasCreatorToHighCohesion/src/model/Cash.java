package model;

public class Cash implements Payment {

	private double discount;

	public Cash(double discount) {
		this.discount = discount / 100;
	}

	@Override
	public String description() {
		return "Dinheiro/Pix";
	}

	@Override
	public Double value(Double saleValue) {
		double value = saleValue - (saleValue * this.discount);
		return value;
	}

}
