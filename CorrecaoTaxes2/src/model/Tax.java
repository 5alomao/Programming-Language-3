package model;

public abstract class Tax {
	private String abbr;
	private String name;
	private double aliquot;

	public Tax(String abbr, String name) throws Exception {
		setAbbr(abbr);
		setName(name);
		// setAliquot(ali);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof Tax))
			return false;

		Tax tax = (Tax) obj;

		return this.abbr.equals(tax.abbr);
	}

	protected abstract double calculate(Product p);

	protected abstract void defineAliquot(Product p) throws Exception;

	private void setAbbr(String abbr) throws Exception {
		if (abbr == null || abbr.equals(""))
			throw new Exception("Abreviação inválida.");

		this.abbr = abbr;
	}

	private void setName(String name) throws Exception {
		if (name == null || name.equals(""))
			throw new Exception("Nome inválido.");

		this.name = name;
	}

	protected void setAliquot(double aliquot) throws Exception {
		if (aliquot <= 0)
			throw new Exception("Alíquota inválida.");

		this.aliquot = aliquot / 100;
	}

	protected double getAliquot() {
		return this.aliquot;
	}

}
