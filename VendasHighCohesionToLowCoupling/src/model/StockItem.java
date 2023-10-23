package model;

public class StockItem {

	private Product objProduct;
	private int amount;

	public StockItem(String codProduct, int amount) {
		String[] prodDesc = DataBase.getProductDescription(codProduct);

		String productDescription = prodDesc[0];
		double productPrice = Double.parseDouble(prodDesc[1]);

		this.objProduct = new Product(productDescription, productPrice);
		this.amount = amount;
	}

	public Product getProduct() {
		return objProduct;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
