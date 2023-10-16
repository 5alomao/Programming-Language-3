package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sale {

	private Date date;
	private List<SaleItem> items;
	private Payment payment;
	
	public Sale(String codPayment) {
		this.date = Calendar.getInstance().getTime();
		this.items = new ArrayList<>();
		this.payment = DataBase.getPaymentDescription(codPayment);
	}

	public Payment getPayment() {
		return payment;
	}

	public void addItem(String codProduct, int amount) {
		SaleItem si = new SaleItem(codProduct, amount);
		items.add(si);
	}

	public double getTotal() {
		double total = 0;
		for (SaleItem saleItem : items) {
			total += saleItem.getSaleItemSubTotal();
		}
		
		return total;
	}

	public Date getDate() {
		return this.date;
	}

	public List<String> getItems() {
		List<String> saleItemsString = new ArrayList<>();
		for (SaleItem si : this.items) {
			String item = String.format("%s - %d - R$%.2f - R$%.2f", si.getProduct().getDescription(),si.getAmount(),
					si.getProduct().getPrice(),si.getSaleItemSubTotal());
			saleItemsString.add(item);
		}
		return saleItemsString;
	}

}
