package com.tcs.multithreads.synchronization;

public class Computer extends Thread{
	static Printer obj = new Printer();
	String str;
	public Computer(String str) {
		super();
		this.str = str;
	}
	public void run() {
		obj.print(str);
	}
	
}
