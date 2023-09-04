package view;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args){
		// TODO
		try {
			Tax IPI = new Tax("IPI", "Imposto Prod. Industrializado", 8);
			Tax IPI2 = new Tax("ICMS", "Imposto Prod. Industrializado", 8);
			Product arroz = new Product("Arroz", 100, 30);
			System.out.println(arroz.addTax(IPI2));
			System.out.println(arroz.addTax(IPI));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
