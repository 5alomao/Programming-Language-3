package view;

import model.CompositeProduct;
import model.LeafProduct;

public class Main {

	public static void main(String[] args) {

		CompositeProduct productsBox = new CompositeProduct();

		CompositeProduct clothingBox = new CompositeProduct();
		LeafProduct tShirt = new LeafProduct(150);
		LeafProduct shorts = new LeafProduct(100);
		LeafProduct hat = new LeafProduct(50);
		clothingBox.add(tShirt);
		clothingBox.add(shorts);
		clothingBox.add(hat);

		productsBox.add(clothingBox);

		CompositeProduct smartphoneBox = new CompositeProduct();
		LeafProduct smartphone = new LeafProduct(3500);
		LeafProduct charger = new LeafProduct(100);
		LeafProduct earphones = new LeafProduct(250);
		smartphoneBox.add(smartphone);
		smartphoneBox.add(charger);
		smartphoneBox.add(earphones);

		productsBox.add(smartphoneBox);

		System.out.println("Valor Total (Caixa de Roupas):" + clothingBox.getPrice());
		System.out.println("Valor Total (Caixa do Celular):" + smartphoneBox.getPrice());
		System.out.println("Valor Total (Caixa de Produtos):" + productsBox.getPrice());

	}
}
