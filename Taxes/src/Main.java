import java.util.Scanner;

public class Main {

	public static int optionsMenu() {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("-- SISTEMA DE VENDAS --");
		System.out.println("[1] - Imposto");
		System.out.println("[2] - Produto");
		System.out.println("[3] - Venda");
		System.out.println("[0] - Encerrar");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		op = sc.nextInt();
		return op;
	}
	
	public static void carregaDados() {

		Tax icms = new Tax("ICMS", 7);
		Tax cofins = new Tax("Cofins", 12);
		Tax ipi = new Tax("IPI", 8);
		Tax iss = new Tax("ISS", 5);
		Tax cide = new Tax("CIDE", 10); 
		Tax csll = new Tax("CSLL", 4);
		MenuTax.addTaxList(icms);
		MenuTax.addTaxList(cofins);
		MenuTax.addTaxList(ipi);
		MenuTax.addTaxList(cide);
		MenuTax.addTaxList(iss);
		MenuTax.addTaxList(csll);
		
		Product arroz = new Product("Arroz",7.0,20);
		MenuProduct.addProductList(arroz);
		arroz.addProductTaxList(icms);
		arroz.addProductTaxList(cofins);
		arroz.addProductTaxList(iss);
		
		
		Product feijao = new Product("Feijão",7.0,25);
		MenuProduct.addProductList(feijao);
		feijao.addProductTaxList(icms);
		feijao.addProductTaxList(cofins);
		feijao.addProductTaxList(iss);
		
		
		Product carne = new Product("Carne",7.0,35);
		MenuProduct.addProductList(carne);
		carne.addProductTaxList(icms);
		carne.addProductTaxList(cofins);
		carne.addProductTaxList(ipi);
		
		
		Product cerveja = new Product("Cerveja",7.0,30);
		MenuProduct.addProductList(cerveja);
		cerveja.addProductTaxList(icms);
		cerveja.addProductTaxList(cofins);
		cerveja.addProductTaxList(iss);
		cerveja.addProductTaxList(ipi);
		
		
		Product gas = new Product("Gás",7.0,15);
		MenuProduct.addProductList(gas);
		gas.addProductTaxList(icms);
		gas.addProductTaxList(cofins);
		gas.addProductTaxList(ipi);
		
		
		Product gasolina = new Product("Gasolina",7.0,15);
		MenuProduct.addProductList(gasolina);
		gasolina.addProductTaxList(icms);
		gasolina.addProductTaxList(cofins);
		gasolina.addProductTaxList(cide);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op, opTax, opProduct, opSale;
		System.out.println("Deseja Carregar Dados");
		System.out.println("[1]- Sim");
		System.out.println("[0] - Não");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		int load = sc.nextInt();
		if(load == 1) {
			carregaDados();
			System.out.println("Dados carregados com sucesso !");
		}
		
		do {
			op = optionsMenu();
			switch (op) {
			case 1:
				opTax = MenuTax.optionsMenuTax();
				MenuTax.switchOpTax(opTax);
				break;
			case 2:
				opProduct = MenuProduct.optionsMenuProduct();
				MenuProduct.switchOpProduct(opProduct);
				break;
			case 3:
				opSale = MenuSale.optionsMenuSale();
				MenuSale.switchOpSale(opSale);
				break;
			case 0:
				System.out.println("Sistema Encerrado com sucesso !");
				break;
			default:
				System.out.println("Opcao invalida !");
			}

		} while (op != 0);

	}

}
