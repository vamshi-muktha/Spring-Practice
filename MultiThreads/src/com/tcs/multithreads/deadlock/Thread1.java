package com.tcs.multithreads.deadlock;

public class Thread1 extends Thread {
	public void run() {
		synchronized (Util.s1) {
			System.out.println("s1 is locked");
			synchronized (Util.s2){
				System.out.println("s2 is locked");
				synchronized (Util.s3) {
					System.out.println("s3 is Locked");
				}
				System.out.println("S3 is released");
			}
			System.out.println("S2 is released");
		}
		System.out.println("S1 is released");
	}
}
