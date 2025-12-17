package com.example.demo.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadData {
	ReadData(){
		System.out.println("created");
	}
	@Autowired
	private DataSource ds;
	
	public void getData() throws SQLException {
		try (Connection con = ds.getConnection();
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery("select * from EMP")) {
			ResultSetMetaData md = rs.getMetaData();
			int cols = md.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i));
					if (i < cols) System.out.print(", ");
				}
				System.out.println();
			}
		}
	}
	
	public void getData2() throws SQLException {
		try (Connection con = ds.getConnection();
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery("select * from DEPT")) {
			ResultSetMetaData md = rs.getMetaData();
			int cols = md.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i));
					if (i < cols) System.out.print(", ");
				}
				System.out.println();
			}
		}
	}
}