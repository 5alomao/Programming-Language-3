package model;

public class Credit implements Payment {

	private double fees;

	public Credit(double fees) {
		this.fees = fees / 100;
	}

	@Override
	public String description() {
		return "Cartão de Crédito";
	}

	@Override
	public Double value(Double saleValue) {
		double value = saleValue + (saleValue * this.fees);
		return value;
	}

}
