package model;

public class ISS extends Tax {

	private static final double ALIQUOT = 5;

	public ISS() throws Exception {
		super("ISS", "Imposto Sobre Serviços");
	}

	@Override
	protected double calculate(Product p) {
		double salePrice = p.getCostPrice() + (p.getCostPrice() * p.getProfit());
		double issCost = salePrice * getAliquot();
		return issCost;
	}

	@Override
	protected void defineAliquot(Product p) throws Exception {
		setAliquot(ALIQUOT);

	}

}
