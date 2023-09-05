package view;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO
		Tax ipi = new Tax("IPI", "Imposto Prod. Industrializado", 8);
		Tax iss = new Tax("ISS", "Imposto Prod. Industrializado", 12);

		Product arroz = new Product("Arroz Pilecco", 100, 30);

		arroz.addTax(ipi);
		arroz.addTax(iss);

		System.out.println(arroz.getName() + "R$: " + arroz.calculateSalePrice());

	}

}
