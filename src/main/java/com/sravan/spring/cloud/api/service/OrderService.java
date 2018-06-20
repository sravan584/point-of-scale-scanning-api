package com.sravan.spring.cloud.api.service;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class OrderService {
	HashMap<String, Double> price= new HashMap<>();
	
	public OrderService() {
		//Initializing the prices
		price.put("A", 1.25);
		price.put("B", 4.25);
		price.put("C", 1.00);
		price.put("D", 0.75);
	}
	
	public Double getOrderPrice(String order) {
		
		Double totalprice=null;
		
		// counting no of Occurrences of A
		int aCount = StringUtils.countOccurrencesOf(order, "A");
		
		// counting no of Occurrences of B
		int bCount = StringUtils.countOccurrencesOf(order, "B");
		
		// counting no of Occurrences of C
		int cCount = StringUtils.countOccurrencesOf(order, "C");
		
		// counting no of Occurrences of D
		int dCount = StringUtils.countOccurrencesOf(order, "D");
		
		//Calculating price of item A
		Double aItemPrice=getTotalItemPriceWithOffer("A", aCount, 3);
		
		//Calculating price of item B
		Double bItemPrice=getTotalItemPriceWithoutOffer("B", bCount);
		
		//Calculating price of item C
		Double cItemPrice=getTotalItemPriceWithOffer("C", cCount, 6);
		
		//Calculating price of item D
		Double dItemPrice=getTotalItemPriceWithoutOffer("D", dCount);
		
		//Calculating total order price
		totalprice=aItemPrice+bItemPrice+cItemPrice+dItemPrice;
		System.out.println("Total price: "+totalprice);
		return totalprice;
	}
	public Double getTotalItemPriceWithOffer(String item,int itemCount,int offer) {
		int qout=itemCount/offer;
		int rem=itemCount%offer;
		Double rate=null;
		switch (item) {
		case "A":
			//Calculating price of item A
			rate=qout*3+rem*price.get(item);
			break;
		case "C":
			//Calculating price of item C
			rate=qout*5+rem*price.get(item);
			break;
		default:
			break;
		}
		return rate;
	}
	public Double getTotalItemPriceWithoutOffer(String item,int itemcount) {
		//Calculating total price of the items without offer
		return itemcount*price.get(item);
	}


}