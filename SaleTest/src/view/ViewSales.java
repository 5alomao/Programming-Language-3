package view;

import model.ItemSale;
import model.Product;
import model.Sale;

public abstract class ViewSales {

	public static void printSale(Sale objSale) {
		for (ItemSale objItemSale : objSale.getProductList()) {
			Product objProduct = objItemSale.getProduct();
			System.out.println(objProduct.getName()+" - "+objItemSale.getAmount()+" - "+objProduct.getCostPrice()+" - "+objItemSale.getTotalCost());
		}
		System.out.println("Valor Total: "+objSale.getFinalPrice());
	}
}
