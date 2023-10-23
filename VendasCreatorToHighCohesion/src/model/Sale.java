package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sale {

	private Date date;
	private List<SaleItem> items;
	private Payment objPayment;

	public Sale() {
		this.date = Calendar.getInstance().getTime();
		this.items = new ArrayList<>();
	}

	public void addItem(String codProduct, int amount) {
		SaleItem si = new SaleItem(codProduct, amount);
		items.add(si);
	}

	public void addPayment(String idPayment) {
		this.objPayment = DataBase.getPayment(idPayment);
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

	public String getPaymentName() {
		return this.objPayment.description();
	}

	public double getPaymentValue() {
		return this.objPayment.value(getTotal());
	}

	public List<String> getItems() {
		List<String> saleItemsString = new ArrayList<>();
		for (SaleItem si : this.items) {
			String item = String.format("%s - %d - R$%.2f - R$%.2f", si.getProduct().getDescription(), si.getAmount(),
					si.getProduct().getPrice(), si.getSaleItemSubTotal());
			saleItemsString.add(item);
		}
		return saleItemsString;
	}

}
