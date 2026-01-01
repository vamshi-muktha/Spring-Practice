package com.tcs.problem2;

public class Transaction {
	private String transactionId;
	private String transactionType;
	private double amount;
	private long timeStamp;
	public Transaction(String transactionId, String transactionType, double amount, long timeStamp) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.timeStamp = timeStamp;
	}
	public Transaction() {
		super();
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", amount="
				+ amount + ", timeStamp=" + timeStamp + "]";
	}
	
	
}
