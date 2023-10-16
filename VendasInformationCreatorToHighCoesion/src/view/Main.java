package view;

//import model.Product;
import model.Sale;
//import model.SaleItem;

public class Main {

	public static void main(String[] args) {

		Sale sale = new Sale("débito");
		sale.addItem("arroz", 3);
		sale.addItem("feijao", 2);
		sale.addItem("sal", 1);

		System.out.println(String.format("Venda - #1234 - %s", sale.getDate().toLocaleString()));

		for (String si : sale.getItems()) {
			System.out.println(si);
		}
		System.out.println(String.format("Forma de Pagamento: %s\nTotal: R$%.2f\nPreço Final: %.2f\n",sale.getPayment().getName(), sale.getTotal(), sale.getPayment().getFinalPrice(sale.getTotal())));
	}

}
