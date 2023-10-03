package model;

public class SaleItem {

	private Product objProduct;
	private int amount;

	public SaleItem(String codProduct, int amount) {
		String[] prodDesc = DataBase.getProductDescription(codProduct);

		String productDescription = prodDesc[0];
		double productPrice = Double.parseDouble(prodDesc[1]);

		this.objProduct = new Product(productDescription, productPrice);
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
