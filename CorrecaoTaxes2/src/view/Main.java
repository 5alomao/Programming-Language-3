package view;

import model.Product;
import model.Tax;
import model.IPI;
import model.ICMS;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO
		Tax ipi = new IPI();
		Tax icms = new ICMS();
		
		Product arroz = new Product("Arroz Pilecco", 100, 30);
		arroz.setIsIndustrial(true);
		arroz.addTax(ipi);
		arroz.addTax(icms);
		System.out.println(arroz.getName() + " R$: " + arroz.calculateSalePrice());
		
		Tax ipiTomate = new IPI();
		Product estratoTomate = new Product("Estrato Heinz", 100, 20);
		estratoTomate.setIsForeign(true);
		estratoTomate.setIsIndustrial(true);
		estratoTomate.addTax(ipiTomate);
		System.out.println(estratoTomate.getName() + "  R$: " + estratoTomate.calculateSalePrice());

	}

}
