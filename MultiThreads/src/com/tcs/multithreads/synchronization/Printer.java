package com.tcs.multithreads.synchronization;

public class Printer {
//	synchronized void print(String msg) {
//		for(int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(msg);
//		}
//	}
	
	void print(String msg) {
		System.out.println("Printer Started...");
		synchronized(this) {
			for(int i = 0; i < 10; i++) {
//				try {
////					Thread.sleep();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(msg);
			}
		}
		System.out.println("Printer Stopped...");
		
	}
}
