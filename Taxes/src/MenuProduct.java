import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuProduct {
	
	private static ArrayList<Product> productList = new ArrayList<>();
	
	public static ArrayList<Product> getProductList() {
		return MenuProduct.productList;
	}
	
	public static void addProductList(Product objProduct) {
		productList.add(objProduct);
	}
	
	public static void switchOpProduct(int opProduct) {
		switch (opProduct) {
		case 1:
			addProductList(insertProduct());
			System.out.println("Produto registrado com sucesso !");
			break;
		case 2:
			if (getProductList().isEmpty())
				System.out.println("Nao existem produtos registrado !");
			else
				addTax();
			break;
		case 3:
			if (getProductList().isEmpty())
				System.out.println("Nao existem produtos registrado !");
			else
				delTax();
			break;
		case 4:
			if (getProductList().isEmpty())
				System.out.println("Nao existem produtos registrado !");
			else {
				if (updateProductProfit() == 1)
					System.out.println("Valor Margem de Lucro alterada com sucesso !");
				else
					System.out.println("Produto nao encontrado !");
			}
			break;
		case 5:
			if (getProductList().isEmpty())
				System.out.println("Nao existem produtos registrado !");
			else {
				System.out.println("-- LISTA DE PRODUTOS --");
				printProductList();
			}
			break;
		case 0:
			return;
		default:
			System.out.println("Opcao invalida !");
		}
	}

	public static int optionsMenuProduct() {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("-- PRODUTO --");
		System.out.println("[1] - Inserir");
		System.out.println("[2] - Adicionar Imposto ");
		System.out.println("[3] - Remover Imposto");
		System.out.println("[4] - Alterar Margem Lucro");
		System.out.println("[5] - Listar");
		System.out.println("[0] - Voltar");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		op = sc.nextInt();
		return op;
	}

	public static Product insertProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-- INSERIR PRODUTO --");
		System.out.println("Nome:");
		String name = sc.nextLine();
		name = name.toUpperCase();
		boolean used = Product.productNameCheck(name);

		while (name.equals("") || name == null || used == true) {
			System.out.println("ERRO, NOME não pode ser vazio, nulo ou estar em uso !");
			System.out.println("Nome:");
			used = false;
			name = sc.nextLine();
			name = name.toUpperCase();
			used = Product.productNameCheck(name);
		}

		System.out.println("Custo:");
		double price = sc.nextDouble();
		boolean check = Product.productPriceCheck(price);
		if (!check) {
			while (!check) {
				System.out.println("ERRO, VALOR não pode ser menor ou igual a zero !");
				System.out.println("Custo:");
				price = sc.nextDouble();
				check = Product.productPriceCheck(price);
			}
		}
		System.out.println("Lucro (%):");
		int profit = sc.nextInt();
		check = Product.productProfitCheck(profit);
		if (!check) {
			while (!check) {
				System.out.println("ERRO, LUCRO não pode ser menor ou igual a zero !");
				System.out.println("Lucro (%):");
				profit = sc.nextInt();
				check = Product.productPriceCheck(profit);
			}
		}
		Product objProduct = new Product(name, price, profit);
		return objProduct;
	}

	public static void addTax() {
		Scanner sc = new Scanner(System.in);
		int idProduct, idTax;
		System.out.println("-- ADICIONAR IMPOSTO --");
		for (Product objProduct : getProductList()) {
			System.out.println("[" + objProduct.getIdProduct() + "] - " + objProduct.getName());
		}
		System.out.println("--------------");
		System.out.println("Digite sua escolha:");
		idProduct = sc.nextInt();
		System.out.println("-- IMPOSTOS --");
		for (Tax objTax : MenuTax.getTaxList())
			System.out.println("[" + objTax.getIdTax() + "] - " + objTax.getType());
		System.out.println("[0] - Encerrar");
		while (true) {
			System.out.println("Digite sua escolha:");
			idTax = sc.nextInt();
			if (idTax == 0)
				break;
			else {
				for (Product objProduct : getProductList()) {
					if (objProduct.getIdProduct() == idProduct) {
						Tax objTax = MenuTax.searchTax(idTax);
						if (objTax == null)
							System.out.println("ERRO, IMPOSTO nao registrado !");
						else {
							objProduct.addProductTaxList(objTax);
							System.out.println("Imposto adicionado ao produto !");
						}
						break;
					}
				}
			}
		}
	}

	public static void delTax() {
		Scanner sc = new Scanner(System.in);
		int idProduct, idTax;
		System.out.println("-- REMOVER IMPOSTO --");
		for (Product objProduct : getProductList()) {
			System.out.println("[" + objProduct.getIdProduct() + "] - " + objProduct.getName());
		}
		System.out.println("--------------");
		System.out.println("Digite sua escolha:");
		idProduct = sc.nextInt();
		System.out.println("-- IMPOSTOS --");
		for (Tax objTax : MenuTax.getTaxList()) {
			System.out.println("[" + objTax.getIdTax() + "] - " + objTax.getType());
		}
		System.out.println("Digite sua escolha:");
		idTax = sc.nextInt();
		for (Product objProduct : getProductList()) {
			if (objProduct.getIdProduct() == idProduct) {
				Tax objTax = MenuTax.searchTax(idTax);
				if (objTax == null)
					System.out.println("ERRO, IMPOSTO nao registrado !");
				else
					objProduct.delProductTaxList(objTax);
				break;
			}
		}
	}

	public static int updateProductProfit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-- ALTERAR MARGEM LUCRO");
		for (Product objProduct : getProductList()) {
			System.out.println("[" + objProduct.getIdProduct() + "] - " + objProduct.getName());
		}
		System.out.println("--------------");
		System.out.println("Digite sua escolha:");
		int idProduct = sc.nextInt();
		System.out.println("Novo Lucro (%)");
		int profit = sc.nextInt();
		boolean check = Product.productProfitCheck(profit);
		if (!check) {
			while (!check) {
				System.out.println("ERRO, LUCRO não pode ser menor ou igual a zero !");
				System.out.println("Valor:");
				profit = sc.nextInt();
				check = Product.productPriceCheck(profit);
			}
		}
		for (Product objProduct : getProductList()) {
			if (objProduct.getIdProduct() == idProduct) {
				objProduct.setProfit(profit);
				objProduct.calcTaxes();
				return 1;
			}
		}
		return -1;
	}

	public static void printProductList() {
		for (Product objProduct : getProductList()) {
			System.out.println("ID: "+objProduct.getIdProduct());
			System.out.println("Nome: "+objProduct.getName());
			System.out.printf("Valor: %.2f\n",objProduct.getPrice());
			System.out.print("Impostos: ");
			for (Tax objTax : objProduct.getProductTaxList()) {
				 System.out.print(objTax.getType()+"; ");
			}
			System.out.println();
			System.out.printf("Valor Impostos: %.2f\n",objProduct.getTaxes());
			System.out.println("Lucro: "+objProduct.getProfit()+"%");
			System.out.printf("Valor Venda: %.2f\n",objProduct.getTotalPrice());
			System.out.println("--------------");
		}
	}
	
}
