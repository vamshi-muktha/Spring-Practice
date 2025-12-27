package com.tcs.irctc.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	
	
	@Id
	private int pnr;
	private String tno;
	@Column(name = "from_station")
	private String from;
	@Column(name = "to_station")
	private String to;
	private String jdate;
	private int fare;
	private String pname;
	private String status;
	
	
	
//	public Ticket(int pnr, String tno, String from, String to, Date jdate, float fare, String pname, String status) {
//		super();
//		this.pnr = pnr;
//		this.tno = tno;
//		this.from = from;
//		this.to = to;
//		this.jdate = jdate;
//		this.fare = fare;
//		this.pname = pname;
//		this.status = status;
//	}
}