package view;

//import model.Product;
import model.Sale;
//import model.SaleItem;

public class Main {

	public static void main(String[] args) {

		Sale sale = new Sale();
		sale.addItem("arroz", 3);
		sale.addItem("feijao", 2);
		sale.addItem("sal", 1);

		sale.addPayment("cd");

		System.out.println(String.format("Venda - #1234 - %s", sale.getDate().toLocaleString()));

		for (String si : sale.getItems()) {
			System.out.println(si);
		}
		System.out.println(String.format("Total: R$%.2f\n", sale.getTotal()));
		System.out.println("Forma de Pagamento: " + sale.getPaymentName());
		System.out.println("Valor a ser Pago: " + sale.getPaymentValue());
	}

}
