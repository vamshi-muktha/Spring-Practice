package com.tcs.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> al = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of transactions");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			//
			System.out.println("-----------------------------");
			System.out.print("Enter the transactionId : ");
			String tid = sc.next();
			System.out.print("Enter the type : ");
			String type = sc.next();
			System.out.print("Enter the amount : ");
			double amt = sc.nextDouble();
			System.out.print("Enter the timeStamp : ");
			long ts = sc.nextLong();
			System.out.println("-----------------------------");
			al.add(new Transaction(tid, type, amt, ts));
			//
		}
//		al.add(new Transaction("TX0001", "NEFT", 5000.0, 787878787));
//		al.add(new Transaction("TX0003", "RTGS", 6000.0, 787878789));
//		al.add(new Transaction("TX0002", "NEFT", 8000.0, 787878723));
//		al.add(new Transaction("TX0005", "IMPS", 2000.0, 787878756));
//		al.add(new Transaction("TX0006", "IMPS", 8000.0, 787878734));
//		al.add(new Transaction("TX0004", "NEFT", 5000.0, 787878712));
		Collections.sort(al, new TransactionComparator());
		
		System.out.println("Sorted");
		for(Transaction ts : al) {
			System.out.println(ts.toString());
		}
		
	}

}
