package model;

public class ICMS extends Tax {

	private static final double INDUSTRIAL_ALIQUOT = 5;
	private static final double NO_INDUSTRIAL_ALIQUOT = 7;

	public ICMS() throws Exception {
		super("ICMS", "Imposto Sobre Circulação de Mercadorias");
	}

	@Override
	protected void defineAliquot(Product p) throws Exception {
		if (p.isIndustrial())
			setAliquot(INDUSTRIAL_ALIQUOT);
		else
			setAliquot(NO_INDUSTRIAL_ALIQUOT);
	}
	
	@Override
	protected double calculate(Product p) {
		double icmsCost = p.getCostPrice() * getAliquot();
		return icmsCost;
	}
	
}
