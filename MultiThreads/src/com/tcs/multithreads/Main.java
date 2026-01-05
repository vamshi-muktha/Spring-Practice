package com.tcs.multithreads;


public class Main {
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		Thread t1 = new Mythread("Hello");
		Thread t2 = new Mythread("World");
		t1.start();
		t2.start();
		Thread t3 = new Thread();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long e = System.currentTimeMillis();
		System.out.println("Completed in >> " + (e - s));
		
	}
}
