package com.sigfig.assignment;

public class Alert implements Comparable<Alert> {
	int netFriends;
	String transactionType;
	String ticker;
	
	
	public Alert(int netFriends, String transactionType, String ticker) {
		this.netFriends = netFriends;
		this.transactionType = transactionType;
		this.ticker = ticker;
	}

	public String toString(){
		return this.netFriends + "," + this.transactionType + "," + this.ticker;
	}

	@Override
	public int compareTo(Alert o) {
		// sort by descending order
		return -Integer.compare(this.netFriends, o.netFriends);
	}
	
}
