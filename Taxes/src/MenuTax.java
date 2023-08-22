import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuTax {
	
	private static ArrayList<Tax> taxList = new ArrayList<>();
	
	public static ArrayList<Tax> getTaxList() {
		return MenuTax.taxList;
	}

	public static void addTaxList(Tax objTax) {
		taxList.add(objTax);
	}
	
	public static void switchOpTax(int opTax) {
		switch (opTax) {
		case 1:
			addTaxList(insertTax());
			System.out.println("Imposto registrado com sucesso !");
			break;
		case 2:
			if (updateTax() == 1)
				System.out.println("Valor do Imposto alterado com sucesso !");
			else
				System.out.println("Imposto não encontrado !");
			break;
		case 3:
			System.out.println("-- LISTA DE IMPOSTOS --");
			printTaxList();
			break;
		case 0:
			return;
		default:
			System.out.println("Opcao invalida !");
		}
	}

	public static int optionsMenuTax() {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("-- IMPOSTO --");
		System.out.println("[1] - Inserir");
		System.out.println("[2] - Alterar Valor");
		System.out.println("[3] - Listar");
		System.out.println("[0] - Voltar");
		System.out.println("--------------");
		System.out.println("Digite sua escolha: ");
		op = sc.nextInt();
		return op;
	}

	public static Tax insertTax() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-- INSERIR IMPOSTO --");
		System.out.println("Tipo:");
		String type = sc.nextLine();
		type = type.toUpperCase();
		boolean used = Tax.taxTypeCheck(type);
		while (type.equals("") || type == null || used == true) {
			System.out.println("ERRO, TIPO não pode ser vazio, nulo ou estar em uso !");
			System.out.println("Tipo:");
			used = false;
			type = sc.nextLine();
			type = type.toUpperCase();
			used = Tax.taxTypeCheck(type);
		}
		System.out.println("Valor:");
		int value = sc.nextInt();
		boolean check = Tax.taxValueCheck(value);
		while (!check) {
			System.out.println("ERRO, VALOR não pode ser menor ou igual a zero !");
			System.out.println("Valor:");
			value = sc.nextInt();
			check = Tax.taxValueCheck(value);
		}
		Tax objTax = new Tax(type, value);
		return objTax;
	}

	public static int updateValueTax(int idTax, int value) {
		for (Tax objTax : getTaxList()) {
			if (objTax.getIdTax() == idTax) {
				objTax.setValue(value);
				return 1;
			}
		}
		return -1;
	}

	public static int updateTax() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-- ALTERAR VALOR IMPOSTO --");
		for (Tax objTax : getTaxList()) {
			System.out.println("[" + objTax.getIdTax() + "] - " + objTax.getType());
		}
		System.out.println("--------------");
		System.out.println("Digite sua escolha:");
		int tax = sc.nextInt();
		System.out.println("Digite o Novo Valor:");
		int value = sc.nextInt();
		boolean check = Tax.taxValueCheck(value);
		while (!check) {
			System.out.println("ERRO, VALOR deve ser maior que zero !");
			System.out.println("Digite o Novo Valor:");
			value = sc.nextInt();
			check = Tax.taxValueCheck(value);
		}
		int result = updateValueTax(tax, value);
		return result;

	}

	public static Tax searchTax(int idTax) {
		for (Tax objTax : getTaxList()) {
			if (objTax.getIdTax() == idTax)
				return objTax;
		}
		return null;
	}
	
	public static void printTaxList() {
		for (Tax objTax : getTaxList()) {
			System.out.println("ID: " + objTax.getIdTax());
			System.out.println("TIPO: " + objTax.getType());
			System.out.println("VALOR: " + objTax.getValue() + "%");
			System.out.println("--------------");
		}
	}
}
