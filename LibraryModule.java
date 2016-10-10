package com.sigfig.assignment;

import java.util.ArrayList;

public class LibraryModule {

	public static ArrayList<Transaction> getTradeTransactionsForUser() throws Exception{
		ArrayList<Transaction> txns = new ArrayList<Transaction>();
		// google
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,SELL,GOOG"));
		txns.add(new Transaction("2016-09-01,SELL,GOOG"));
		// microsoft
		txns.add(new Transaction("2016-09-01,BUY,MSFT"));
		txns.add(new Transaction("2016-08-28,BUY,MSFT"));
		txns.add(new Transaction("2016-08-10,SELL,MSFT"));
		txns.add(new Transaction("2016-08-10,SELL,MSFT"));
		txns.add(new Transaction("2016-07-31,SELL,MSFT"));
		// yahooo
		txns.add(new Transaction("2016-07-15,SELL,YHOO"));
		txns.add(new Transaction("2016-07-10,SELL,YHOO"));
		txns.add(new Transaction("2016-06-29,SELL,YHOO"));
		txns.add(new Transaction("2016-06-20,SELL,YHOO"));
		// amazon
		txns.add(new Transaction("2016-06-20,BUY,AMZN"));
		txns.add(new Transaction("2016-06-20,SELL,AMZN"));
		return txns;
	}
}
