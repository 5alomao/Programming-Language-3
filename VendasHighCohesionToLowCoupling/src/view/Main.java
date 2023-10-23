package view;

//import model.Product;
import model.SaleManager;
//import model.SaleItem;

public class Main {

	public static void main(String[] args) throws Exception {

		SaleManager objSaleManager = new SaleManager();

		objSaleManager.addItem("arroz", 3);
		objSaleManager.addItem("feijao", 5);
		objSaleManager.addItem("sal", 5);
		objSaleManager.addPayment("cd");

		objSaleManager.printSale();
		
		objSaleManager.printStock();
	}

}
