import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuSale {
	
	private static ArrayList<Sale> saleList = new ArrayList<>();
	
	public static ArrayList<Sale> getSaleList() {
		return MenuSale.saleList;
	}

	public static void addSaleList(Sale objSale) {
		saleList.add(objSale);
	}
	
	public static void switchOpSale(int opSale) {
		switch (opSale) {
		case 1:
			addSaleProduct();
			break;
		case 2:
			printSaleList();
			break;
		case 0:
			return;
		default:
			System.out.println("Opcao invalida !");
		}
	}

	public static int optionsMenuSale() {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("-- VENDA --");
		System.out.println("[1] - Inserir");
		System.out.println("[2] - Listar");
		System.out.println("[0] - Voltar");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		op = sc.nextInt();
		return op;
	}
	
	public static int productListBuy() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" LISTA DE PRODUTOS");
		for (Product objProduct : MenuProduct.getProductList()) {
			System.out.println("[" + objProduct.getIdProduct() + "] - " + objProduct.getName());
		}
		System.out.println("[0] - Finalizar");
		System.out.println("--------------");
		System.out.println("Inserir no carrinho:");
		int buy = sc.nextInt();
		return buy;
	}
	
	public static void addSaleProduct() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> saleProductList = new ArrayList<>();
		System.out.println("Cliente:");
		String customer = sc.nextLine();
		while(customer.equals("") || customer == null) {
			System.out.println("ERRO, CLIENTE nao poder ter nome vazio ou nulo");
			System.out.println("Cliente:");
			customer = sc.nextLine();
		}
		int buy = productListBuy();
		while(buy != 0) {
			for (Product objProduct : MenuProduct.getProductList()) {
				if(objProduct.getIdProduct() == buy) {
					saleProductList.add(objProduct);
				}	
			}
			buy = productListBuy();
		}
		System.out.println("--------------");
		System.out.println("[1] - Finalizar Venda");
		System.out.println("[0] - Cancelar Venda");
		System.out.println("--------------");
		int saleOp = sc.nextInt();
		if(saleOp == 0) {
			System.out.println("Venda cancelada com sucesso !");
		}
		else if(saleOp == 1) {
			Sale sale = new Sale(customer, saleProductList);
			addSaleList(sale);
			System.out.println("Venda finalizada com sucesso !");
		}else 
			System.out.println("Opcao invalida");

	}
	public static void printSaleList(){
		Scanner sc = new Scanner(System.in); 
		System.out.println("-- LISTA DE VENDAS --");
		for (Sale objSale : getSaleList()) {
			System.out.println("["+objSale.getIdSale()+"] - "+objSale.getCustomer());
		}
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		int idSale = sc.nextInt();
		boolean exist = false;
		for (Sale objSale : getSaleList()) {
			if(objSale.getIdSale() == idSale) {
				exist = true;
				printListProduct(objSale);
				System.out.println("Valor Total Venda:"+objSale.getTotalPriceSale());
			}
		}
		if(!exist)
			System.out.println("Venda nao encontrada !");
		
	}
	
	public static void printListProduct(Sale objSale) {
		for (Product objProduct : objSale.getSaleProductList()) {
			System.out.printf("ID: %d | %s | R$: %.2f\n",objProduct.getIdProduct(),objProduct.getName(),objProduct.getTotalPrice());
		}
		
	}
}
