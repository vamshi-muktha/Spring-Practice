package com.tcs.multithreads;

public class ThreadWithRunnable implements Runnable {
	private String msg;

	public ThreadWithRunnable(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(msg + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadWithRunnable tr1 = new ThreadWithRunnable("Hello");
		ThreadWithRunnable tr2 = new ThreadWithRunnable("World");
		Thread tt = new Thread(() -> {
			
			for(int i = 0; i < 10; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hello Bye");
			}
		});
		Thread t1 = new Thread(tr1);
		Thread t2 = new Thread(tr2);
		t1.start();
		t2.start();
		tt.start();
		
	}

}
