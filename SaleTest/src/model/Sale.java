package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<ItemSale> productList;
	private double finalPrice;
	
	public Sale() {
		this.productList = new ArrayList<ItemSale>();
	}

	public void addItemSale(ItemSale objItemSale) throws Exception {
		if (objItemSale == null)
			throw new Exception("Produto não pode ser nulo.");
		
		finalPrice += objItemSale.calculatePrice();
		productList.add(objItemSale);
	}
	
	public double getFinalPrice() {
		return this.finalPrice;
	}
	
	public List<ItemSale> getProductList() {
		List <ItemSale> copyProductList = new ArrayList<>(productList);
		return copyProductList;
	}
}
