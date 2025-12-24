package com.tcs.irctc.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Passenger {
	private String name;
	private String tno;
	private String from;
	private String to;
	private String jdate;
}
