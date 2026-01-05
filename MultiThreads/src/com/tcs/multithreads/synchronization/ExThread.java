package com.tcs.multithreads.synchronization;

public class ExThread {
	public static void main(String[] args) {
		Thread c1 = new Computer("one");
		Thread c2 = new Computer("two");
		Thread c3 = new Computer("three");
		c3.start();
		c1.start();
		c2.start();
		
	}
}
