import java.util.ArrayList;

public class Product {

	private int idProduct;
	private String name;
	private double price;
	private int profit;
	private double taxes;
	private double totalPrice;
	private static int productAmount = 0;
	private ArrayList<Tax> productTaxList = new ArrayList<>();
	
	public Product(String name, double price, int profit) {
		Product.productAmount +=1;
		this.idProduct = Product.productAmount;
		this.name = name;
		this.price = price;
		this.profit = profit;
		calcTaxes();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getIdProduct() {
		return idProduct;
	}
	
	
	public double getTaxes() {
		return taxes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public ArrayList<Tax> getListTaxes() {
		return productTaxList;
	}
	
	
	public static int getProductAmount() {
		return Product.productAmount;
	}

	public ArrayList<Tax> getProductTaxList() {
		return productTaxList;
	}
	
	public static boolean productNameCheck(String name) {
		boolean used = false;
		for (Product objProduct : MenuProduct.getProductList()) {
			if (objProduct.getName().equals(name))
				used = true;
			if (used)
				break;
		}
		return used;
	}
	
	public static boolean productPriceCheck(double price) {
		boolean check = false;
		if (price > 0)
			check = true;
		return check;
	}
	
	public static boolean productProfitCheck(double profit) {
		boolean check = false;
		if (profit > 0)
			check = true;
		return check;
	} 

	public void addProductTaxList(Tax objTax) {
		if(getProductTaxList().contains(objTax))
			System.out.println("Imposto ja adicionado !");
		else {
			this.taxes += objTax.getValue() * price / 100;
			productTaxList.add(objTax);
			calcTaxes();
		}
	}
	
	public void delProductTaxList(Tax objTax) {
		if(getProductTaxList().contains(objTax)) {
			this.taxes -= objTax.getValue() * price / 100;
			productTaxList.remove(objTax);
			calcTaxes();
			System.out.println("Imposto removido do produto !");
		} else 
			System.out.println("Imposto nao adicionado !");
		
	}
	
	public void calcTaxes() {
		double total = price + taxes;
		double calcProfit = (total * profit)/100;
		if(productTaxList.isEmpty()) {
			this.totalPrice = price + calcProfit;
		} else {
			this.totalPrice = total+calcProfit;
		}
	}
	
}
