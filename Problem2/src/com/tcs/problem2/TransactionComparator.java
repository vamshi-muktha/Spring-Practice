package com.tcs.problem2;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction>{

	@Override
	public int compare(Transaction o1, Transaction o2) {
		return (int) (priority(o1) == priority(o2) ? (o1.getAmount() == o2.getAmount() ? o2.getTimeStamp() - o1.getTimeStamp() : o2.getAmount() - o1.getAmount()) : priority(o2) - priority(o1));   
	}

	private int priority(Transaction o1) {
		// TODO Auto-generated method stub
		if(o1.getTransactionType().equals("RTGS"))return 3;
		if(o1.getTransactionType().equals("NEFT"))return 1;
		if(o1.getTransactionType().equals("IMPS"))return 2;
		return 0;
	}

}
