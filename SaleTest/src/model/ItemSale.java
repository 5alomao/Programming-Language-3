package model;

public class ItemSale {

	private Product objProduct;
	private int amount;
	private double totalCost;
	
	public ItemSale(Product objProduct, int amount) {
		this.objProduct = objProduct;
		this.amount = amount;
	}
	
	public double calculatePrice () {
		this.totalCost = objProduct.getCostPrice() * this.amount;
		return totalCost;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public double getTotalCost() {
		return this.totalCost;
	}
	
	public Product getProduct() {
		return this.objProduct;
	}

}
