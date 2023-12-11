package model;

import java.util.ArrayList;

public class CompositeProduct implements ComponentProduct {

	private ArrayList<ComponentProduct> products = new ArrayList<>();

	@Override
	public double getPrice() {
		double sum = 0;
		for (ComponentProduct cp : products) {
			sum += cp.getPrice();
		}
		return sum;
	}

	public void add(ComponentProduct objComponentProduct) {
		products.add(objComponentProduct);
	}

	public void remove(ComponentProduct objComponentProduct) {
		products.remove(objComponentProduct);
	}

}
