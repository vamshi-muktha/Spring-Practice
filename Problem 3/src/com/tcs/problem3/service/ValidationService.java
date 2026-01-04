package com.tcs.problem3.service;

public class ValidationService {

	public boolean isValidClaim(String fileName) {

		if (fileName == null)
			return false;
		return fileName.startsWith("claim");
	}

}
