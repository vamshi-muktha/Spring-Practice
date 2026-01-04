package com.tcs.problem1;

import java.util.Scanner;

import com.tcs.problem1.service.ValidationService;

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
			String res = ValidationService.validate(code);
			System.out.println(res);
		}
			
	}

	
}
