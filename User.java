package com.sigfig.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class User {
	// for the sake of brevity skipped User fields
	
	// get alerts for the user
	// overall time complexity: O(nlogn)  
	public  static List<Alert> getAlerts(List<Transaction> txns){
		// store map such that if transaction is BUY then add 1 else subtract 1
		HashMap<String, Integer> alerts = new HashMap<String, Integer>();
		for (Transaction transaction : txns) {
			// if ticker exists in hashmap then update the value
			if (alerts.containsKey(transaction.ticker)) {
				if(transaction.transactionType.equals("BUY")){
					alerts.put(transaction.ticker, alerts.get(transaction.ticker) + 1);
				} else {
					alerts.put(transaction.ticker, alerts.get(transaction.ticker) - 1);
				}
				
			}
			// if ticker does not exist then insert new value
			else {
				if(transaction.transactionType.equals("BUY")){
					alerts.put(transaction.ticker, 1);
				} else {
					alerts.put(transaction.ticker, -1); // -1 if Sell
				}
			}
		}
		
		// put it in array list for sorting
		ArrayList<Alert> sortedAlerts = new ArrayList<Alert>();
		
		for(String key: alerts.keySet()){
			if(alerts.get(key) < 0){
				sortedAlerts.add(new Alert(Math.abs(alerts.get(key)), "SELL", key));
			} else if(alerts.get(key) > 0){
				sortedAlerts.add(new Alert(Math.abs(alerts.get(key)), "BUY", key));
			} else {
				// this means value = 0 , then simply ignore
			}
		}
		// O(nlogn)
		Collections.sort(sortedAlerts); // sort list 
		return sortedAlerts;
	}
	
}

