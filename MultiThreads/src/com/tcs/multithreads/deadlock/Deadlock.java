package com.tcs.multithreads.deadlock;

public class Deadlock {
	public static void main(String[] args) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread1();
		t1.start();
		t2.start();
		
	}
}
