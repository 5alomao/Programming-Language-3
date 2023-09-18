package model;

public class IPI extends Tax {

	private static final double FOREIGN_ALIQUOT = 10;
	private static final double LOCAL_ALIQUOT = 8;

	public IPI() throws Exception {
		super("IPI", "Imposto Sobre Produtos Industrialiazdos");
	}

	@Override
	public double calculate(Product p) {
		double ipiCost = p.getCostPrice() * this.getAliquot();
		return ipiCost;
	}

	@Override
	public void defineAliquot(Product p) throws Exception {
		if (p.isForeign())
			setAliquot(FOREIGN_ALIQUOT);
		else
			setAliquot(LOCAL_ALIQUOT);
	}

}
