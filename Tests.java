package com.sigfig.assignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests {
	ArrayList<Transaction> txns = new ArrayList<Transaction>();

	@Before
	public void setUp() throws Exception {
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,BUY,GOOG"));
		txns.add(new Transaction("2016-10-09,SELL,GOOG"));
		txns.add(new Transaction("2016-09-01,SELL,GOOG"));
		txns.add(new Transaction("2016-09-01,BUY,MSFT"));
		txns.add(new Transaction("2016-08-28,BUY,MSFT"));
		txns.add(new Transaction("2016-08-10,SELL,MSFT"));
		txns.add(new Transaction("2016-08-10,SELL,MSFT"));
		txns.add(new Transaction("2016-07-31,SELL,MSFT"));
		txns.add(new Transaction("2016-07-15,SELL,YHOO"));
		txns.add(new Transaction("2016-07-10,SELL,YHOO"));
		txns.add(new Transaction("2016-06-29,SELL,YHOO"));
		txns.add(new Transaction("2016-06-20,SELL,YHOO"));
	}

	@After
	public void tearDown() throws Exception {
		txns.clear();
	}

	@Test
	public void invalidTxn1() throws Exception {
		try {
			new Transaction("2016-10-10,XXX,GOOG");
		} catch (Exception e) {
			assertEquals("Invalid string format for transaction", e.getMessage());
		}
	}

	@Test
	public void invalidTxn2() throws Exception {
		try {
			new Transaction("2016-10-10,BUY,GOOG XXX");
		} catch (Exception e) {
			assertEquals("Invalid string format for transaction", e.getMessage());
		}

	}
	
	@Test
	public void emptyTxnsList() throws Exception {
		List<Transaction> txns = new ArrayList<Transaction>();
		List<Alert> actual = User.getAlerts(txns);
		assertEquals(0, actual.size());

	}
	
	@Test
	public void allValidTxns() throws Exception {
		List<Alert> actual = User.getAlerts(txns);
		List<Alert> expected = new ArrayList<Alert>(
				Arrays.asList(
						new Alert(4, "SELL", "YHOO"), 
						new Alert(3, "BUY", "GOOG"), 
						new Alert(1, "SELL", "MSFT")));

		assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(actual.toArray()));	
	}

	@Test
	public void allBuyTxns() throws Exception {
		txns.clear();
		txns.add(new Transaction("2016-10-10,BUY,MSFT"));
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-10,BUY,YHOO"));
		List<Alert> actual = User.getAlerts(txns);
		List<Alert> expected = new ArrayList<Alert>(
				Arrays.asList(
						new Alert(1, "BUY", "MSFT"), 
						new Alert(1, "BUY", "GOOG"), 
						new Alert(1, "BUY", "YHOO")));

		assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(actual.toArray()));	

	}

	@Test
	public void allSellTxns() throws Exception {
		txns.clear();
		txns.add(new Transaction("2016-10-10,SELL,GOOG"));
		txns.add(new Transaction("2016-10-10,SELL,MSFT"));
		txns.add(new Transaction("2016-10-10,SELL,YHOO"));
		List<Alert> actual = User.getAlerts(txns);
		List<Alert> expected = new ArrayList<Alert>(Arrays.asList(
				new Alert(1, "SELL", "MSFT"),
				new Alert(1, "SELL", "GOOG"), 
				new Alert(1, "SELL", "YHOO")));

		assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(actual.toArray()));	

	}

	@Test
	public void ZeroBuySell() throws Exception {
		txns.clear();
		txns.add(new Transaction("2016-10-10,BUY,GOOG"));
		txns.add(new Transaction("2016-10-10,SELL,GOOG"));
		List<Alert> actual = User.getAlerts(txns);
		
		assertEquals(0, actual.size());

	}

	
}
