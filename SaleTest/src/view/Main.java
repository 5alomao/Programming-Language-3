package view;

import model.ItemSale;
import model.Product;
import model.Sale;

public class Main {

	public static void main(String[] args) throws Exception{
		
		Product arroz = new Product("Arroz",20);
		Product feijao = new Product("Feijao",15);
		
		ItemSale item1 = new ItemSale(arroz,5);
		ItemSale item2 = new ItemSale(feijao,2);
		
		Sale venda1 = new Sale();
		venda1.addItemSale(item1);
		venda1.addItemSale(item2);
		
		ViewSales.printSale(venda1);
	}

}
