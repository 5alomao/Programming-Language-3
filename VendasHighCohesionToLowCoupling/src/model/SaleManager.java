package model;

public class SaleManager {

	private Sale objSale;

	public SaleManager() {
		objSale = new Sale();
	}

	public void addItem(String codProduct, int amount) throws Exception {
		if (Stock.stockCheck(codProduct, amount)) {
			objSale.addItem(codProduct, amount);
		} else {
			throw new Exception("Sem estoque para o produto.");
		}
	}

	public void addPayment(String idPayment) throws Exception {
		Payment objPayment = DataBase.getPayment(idPayment);
		if (objPayment != null)
			this.objSale.addPayment(objPayment);
		else
			throw new Exception("Forma de pagamento não existe.");
	}

	public void printSale() {
		System.out.println(String.format("Venda - #1234 - %s", objSale.getDate().toLocaleString()));
		for (String si : objSale.getItems()) {
			System.out.println(si);
		}
		System.out.println(String.format("Total: R$%.2f\n", objSale.getTotal()));
		System.out.println("Forma de Pagamento: " + objSale.getPaymentName());
		System.out.println("Valor a ser Pago: " + objSale.getPaymentValue());
	}
	
	public static void printStock() {
		System.out.println("==-- Estoque de Produtos --==");
		System.out.println(String.format("Produto: %s | Quantidade: %d",Stock.getStockItems("arroz").getProduct().getDescription(), Stock.getStockItems("arroz").getAmount()));
		System.out.println(String.format("Produto: %s | Quantidade: %d",Stock.getStockItems("feijao").getProduct().getDescription(), Stock.getStockItems("feijao").getAmount()));
		System.out.println(String.format("Produto: %s | Quantidade: %d",Stock.getStockItems("sal").getProduct().getDescription(), Stock.getStockItems("sal").getAmount()));
	}
}
