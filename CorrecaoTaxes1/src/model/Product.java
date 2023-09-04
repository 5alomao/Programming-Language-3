package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice;
	private double profit;
	private List<Tax> taxes;

	public Product(String name, double costPrice, double profit) throws Exception {
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		this.taxes = new ArrayList<>();
	}
	
	public boolean addTax(Tax objTax) throws Exception{
		
		if(objTax == null)
			throw new Exception("Imposto não pode ser nulo.");
		
		if(taxes.contains(objTax))
			return false; 
		else 
			taxes.add(objTax);
		
		return true;
		
	}

	private void setProfit(double profit) throws Exception{
		if(profit <= 0)
			throw new Exception("Margem de lucro inválida.");
		
		this.profit = profit/100;
	}

	private void setCostPrice(double costPrice) throws Exception {
		if(costPrice <= 0)
			throw new Exception("Preço de custo inválido.");
		
		this.costPrice = costPrice;
	}

	private void setName(String name) throws Exception {
		if(name == null || name.equals(""))
			throw new Exception("Nome inválido.000");
				
		this.name = name;
	}
	
}
