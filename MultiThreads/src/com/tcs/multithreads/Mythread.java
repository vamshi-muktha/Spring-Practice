package com.tcs.multithreads;

public class Mythread extends Thread {
	String msg;
	public Mythread(String msg) {
		this.msg = msg;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(msg);
			
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 

}
