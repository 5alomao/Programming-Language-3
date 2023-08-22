public class Tax {

	private int idTax;
	private String type;
	private int value;
	private static int taxAmount = 0;
	
	public Tax(String type, int value) {
		Tax.taxAmount += 1;
		this.idTax = Tax.taxAmount;
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIdTax() {
		return idTax;
	}

	public static int getTaxAmount() {
		return Tax.taxAmount;
	}

	public static boolean taxTypeCheck(String type) {
		boolean used = false;
		for (Tax objTax : MenuTax.getTaxList()) {
			if (objTax.getType().equals(type))
				used = true;
			if (used)
				break;
		}
		return used;
	}

	public static boolean taxValueCheck(int value) {
		boolean check = false;
		if (value > 0)
			check = true;
		return check;
	}

}
