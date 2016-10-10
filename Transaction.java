package com.sigfig.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {
	Date date;
	String transactionType;
	String ticker;
	
	// parse string format into objects
	// ex: “2014-01-01,BUY,GOOG”
	public Transaction(String record) throws Exception {
	 String[] values = record.split(",");
	 if(values.length < 3 || values.length > 3){
		 throw new Exception("Invalid string format for transaction");
	 }
	 DateFormat format = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
	 this.date = format.parse(values[0]);
	 
	 // check transaction type strings
	 if(!values[1].equals("BUY") && !values[1].equals("SELL")){
		 throw new Exception("Invalid string format for transaction");
	 }
	 this.transactionType = values[1];
	 this.ticker = values[2];
	}
	
	// returns string format of the object
	public String toString(){
		DateFormat format = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
		return format.format(this.date) + "," + this.transactionType + "," + this.ticker;
	}
}
