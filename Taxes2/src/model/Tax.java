package model;

public class Tax {
	private String abbr;
	private String name;
	private double aliquot;

	public Tax(String abbr, String name, double ali) throws Exception {
		setAbbr(abbr);
		setName(name);
		setAliquot(ali);
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

	public double calculate(Product p) {
		if (this.abbr.equals("ICMS"))
			if (!p.getIndustrialized())
				return p.getCostPrice() * 0.07;

		if (this.abbr.equals("IPI"))
			if (p.getOrigin().toUpperCase().equals("IMPORTADO"))
				return p.getCostPrice() * 0.10;

		if (this.abbr.equals("ISS")) {
			double finalCost = p.getCostPrice() + (p.getCostPrice() * p.getProfit());
			return finalCost * this.aliquot;
		}

		return p.getCostPrice() * aliquot;
	}

	public String getAbbr() {
		return this.abbr;
	}

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

	private void setAliquot(double aliquot) throws Exception {
		if (aliquot <= 0)
			throw new Exception("Alíquota inválida.");

		this.aliquot = aliquot / 100;
	}

}
