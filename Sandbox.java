package com.sigfig.assignment;

import java.util.List;

public class Sandbox {	
	public static void main(String args[]) throws Exception {
		List<Transaction> txns = LibraryModule.getTradeTransactionsForUser();
		List<Alert> alerts = User.getAlerts(txns);
		
		for(Alert alert: alerts){
			System.out.println(alert.toString());
		}
	}
}
