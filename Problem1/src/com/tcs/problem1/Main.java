package com.tcs.problem1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("Enter 0 if you want to exit");
			System.out.println("-----------------------------");
			System.out.print("Enter the SWIFT/BIC Code : ");
			String code = sc.nextLine();
			if(code.equals("0"))break;
			String res = validate(code);
			System.out.println(res);
		}
			
	}

	public static String validate(String code) {
		// TODO Auto-generated method stub
		int cnt = 0;
		boolean f = false;
		for(char ch : code.toCharArray()) {
			if(ch == ' ') {
				f = true;
			}
			else cnt ++;
			
		}
		if(cnt == 8 || cnt == 11)if(f)return "This Code is INVALID \nCode contains non-alphanumeric Characters";
		int n = code.length();
		if(n < 8) {
			return "This Code is INVALID \nLength is too Short";
		}
		else if(n > 11) {
			return "This Code is INVALID \nLength is too Long";
		}
		else if(n > 8 && n < 11) {
			return "This Code is INVALID \nLength is not Valid";
		}
		
		
//		if(n == 8) {
//			code = code.concat("XXX");
//			System.out.println(code);
//		}
		String institutionCode = code.substring(0, 4);
		for(char ch : institutionCode.toCharArray()) {
			if(Character.isDigit(ch)) {
				return "Input : "+ code +" is INVALID \nInstitution Code must be Alphabetic";
			}
		}
		String countryCode = code.substring(4, 6);
		for(char ch : countryCode.toCharArray()) {
			if(Character.isDigit(ch)) {
				return "Input : "+ code +" is INVALID \nCountry Code must be Alphabetic";
			}
		}
		
		String locationCode = code.substring(6, 8);
		for(char ch : locationCode.toCharArray()) {
			if(!Character.isDigit(ch) && !Character.isAlphabetic(ch)) {
				return "Input : "+ code +" is INVALID \nLoation Code contains Invalid Characters";
			}
		}
		if(n == 11) {
			String branchCode = code.substring(8, 11);
			for(char ch : branchCode.toCharArray()) {
				if(!Character.isDigit(ch) && !Character.isAlphabetic(ch)) {
					return "Input : "+ code +" is INVALID \nBranch Code contains Invalid Characters";
				}
			}
			
		}
		return "Input : " + code + " is VALID";
			
	}
}
