package com.tcs.problem1.service;

public class ValidationService {
	public static String validate(String code) {
		String str = "";
		int n = code.length();
		int cnt = 0;
		boolean f = false;
		for(int i = 0; i < n; i++) {
			char ch = code.charAt(i);
			if(!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
				if(i < 4)return "Input : "+ code +" is INVALID \nInstitution Code contains special characters";
				if(i < 6)return "Input : "+ code +" is INVALID \nCountry Code contains special characters";
				if(i < 8)return "Input : "+ code +" is INVALID \nLocation Code contains special characters";
				else return "Input : "+ code +" is INVALID \nBranch Code contains special characters";
			}
			if(ch == ' ') {
				f = true;
			}
			else cnt ++;
			
		}
		
		if(cnt == 8 || cnt == 11)if(f)return "This Code is INVALID \nCode contains non-alphanumeric Characters";
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
