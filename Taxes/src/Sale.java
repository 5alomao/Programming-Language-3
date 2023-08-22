import java.util.ArrayList;

public class Sale {

	public static int saleAmount = 0;
	private double totalPriceSale;
	private int idSale;
	private String customer;
	private ArrayList<Product> saleProductList = new ArrayList<>();
	
	public Sale(String customer, ArrayList<Product> saleProductList) {
		Sale.saleAmount += 1;
		this.idSale = Sale.saleAmount;
		this.customer = customer;
		this.saleProductList.addAll(saleProductList);
		calcSaleTotalPrice();
	}
	
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public static int getSaleAmount() {
		return Sale.saleAmount;
	}

	public int getIdSale() {
		return idSale;
	}

	public ArrayList<Product> getSaleProductList() {
		return saleProductList;
	}

	public double getTotalPriceSale() {
		return totalPriceSale;
	}
	
	public void calcSaleTotalPrice() {
		for (Product objProduct : saleProductList) {
			this.totalPriceSale += objProduct.getTotalPrice();
		}
	}
	
}
