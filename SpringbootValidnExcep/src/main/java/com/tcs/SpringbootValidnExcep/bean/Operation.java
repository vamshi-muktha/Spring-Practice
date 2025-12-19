package com.tcs.SpringbootValidnExcep.bean;

public class Operation {
	private int inp1;
	private int inp2;
	private int res;
	
	
	public Operation(int inp1, int inp2) {
		super();
		this.inp1 = inp1;
		this.inp2 = inp2;
	}
	public int getInp1() {
		return inp1;
	}
	public void setInp1(int inp1) {
		this.inp1 = inp1;
	}
	public int getInp2() {
		return inp2;
	}
	public void setInp2(int inp2) {
		this.inp2 = inp2;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	@Override
	public String toString() {
		return "Operation [inp1=" + inp1 + ", inp2=" + inp2 + ", res=" + res + "]";
	}
	
	
	
}
