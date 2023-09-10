package view;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO
		Tax ipi = new Tax("IPI", "Imposto Prod. Industrializado", 8);
		Tax iss = new Tax("ISS", "Imposto Sobre Serviço", 5);
		Tax icms = new Tax("ICMS", "Imposto Sobre Circulação de Mercadorias e Serviços", 5);

		Product arroz = new Product("Arroz", 7, 20, "Nacional");
		Product feijao = new Product("Feijão", 7, 25, "Nacional");
		Product carne = new Product("Carne", 7, 35, "Nacional");
		Product cerveja = new Product("Cerveja", 7, 30, "Nacional");
		Product gas = new Product("Gás", 7, 15, "Nacional");
		Product gasolina = new Product("Gasolina", 7, 15, "Nacional");

		arroz.addTax(icms);
		arroz.addTax(iss);

		feijao.addTax(icms);
		feijao.addTax(iss);

		carne.addTax(icms);
		carne.addTax(ipi);

		cerveja.addTax(icms);
		cerveja.addTax(iss);
		cerveja.addTax(ipi);

		gas.addTax(icms);
		gas.addTax(ipi);

		gasolina.addTax(icms);

		printProduct(arroz);
		printProduct(feijao);
		printProduct(carne);
		printProduct(cerveja);
		printProduct(gas);
		printProduct(gasolina);
	}

	public static void printProduct(Product p) {
		System.out.println("Nome: " + p.getName());
		System.out.printf("Preço: %.2f\n", p.calculateSalePrice());
		System.out.println("--- --- --- ---");
	}
}
