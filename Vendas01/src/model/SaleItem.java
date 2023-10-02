package model;

public class SaleItem {
	
	private Product objProduct;
	private int amount;
	
	public SaleItem(Product objProduct, int amount) {
		this.objProduct = objProduct;
		this.amount = amount;
	}
	
	public Product getProduct() {
		return this.objProduct;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public double getSaleItemSubTotal() {
		return this.amount * objProduct.getPrice();
	}
}
