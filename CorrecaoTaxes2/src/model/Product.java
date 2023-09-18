package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice;
	private double profit;
	private boolean foreign;
	private boolean industrial;
	private List<Tax> taxes;

	public Product(String name, double costPrice, double profit) throws Exception {
		this.foreign = false;
		this.industrial = false;
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		this.taxes = new ArrayList<>();
	}

	public void setIsForeign(boolean foreign) {
		this.foreign = foreign;
	}

	public boolean isForeign() {
		return this.foreign;
	}
	
	public void setIsIndustrial(boolean industrial) {
		this.industrial = industrial;
	}
	
	public boolean isIndustrial() {
		return this.industrial;
	}
	
	public double calculateSalePrice() {
		double taxSum = 0;
		for (Tax tax : taxes) {
			taxSum += tax.calculate(this);
		}

		double finalCost = this.costPrice + taxSum;

		double finalPrice = finalCost + (finalCost * profit);
		return finalPrice;
	}

	public boolean addTax(Tax objTax) throws Exception {

		if (objTax == null)
			throw new Exception("Imposto não pode ser nulo.");

		if (taxes.contains(objTax))
			return false;
		else {
			objTax.defineAliquot(this);
			taxes.add(objTax);
		}

		return true;

	}

	public String getName() {
		return this.name;
	}

	public double getCostPrice() {
		return this.costPrice;
	}
	
	public double getProfit() {
		return this.profit;
	}
	
	private void setProfit(double profit) throws Exception {
		if (profit <= 0)
			throw new Exception("Margem de lucro inválida.");

		this.profit = profit / 100;
	}

	private void setCostPrice(double costPrice) throws Exception {
		if (costPrice <= 0)
			throw new Exception("Preço de custo inválido.");

		this.costPrice = costPrice;
	}

	private void setName(String name) throws Exception {
		if (name == null || name.equals(""))
			throw new Exception("Nome inválido.000");

		this.name = name;
	}

}
