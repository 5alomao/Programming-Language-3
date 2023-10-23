package model;

import java.util.HashMap;
import java.util.Map;

public abstract class Stock {

	private static Map<String, StockItem> stockItems = new HashMap();

	static {
		stockItems.put("arroz", new StockItem("arroz", 5));
		stockItems.put("feijao", new StockItem("feijao", 10));
		stockItems.put("sal", new StockItem("sal", 15));
	}

	public static void addStock(String codProduct, int amount) {
		StockItem si = new StockItem(codProduct, amount);
		stockItems.put(codProduct, si);
	}

	public static boolean stockCheck(String codProduct, int amount) {
		StockItem objStockItem = Stock.getStockItems(codProduct);

		if (objStockItem.getAmount() >= amount) {
			objStockItem.setAmount(objStockItem.getAmount() - amount);
			return true;
		}

		return false;
	}

	public static StockItem getStockItems(String key) {
		return stockItems.get(key);
	}
	
}
