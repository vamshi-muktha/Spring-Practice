package com.tcs.springMVCwithjdbc.jdbc;


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
	public ReadData(){
		System.out.println("created");
	}
	@Autowired
	private DataSource ds;

	public String getData(String sql) throws SQLException {
		StringBuilder sb = new StringBuilder();
		try (Connection con = ds.getConnection();
				 Statement st = con.createStatement();
				 ResultSet rs = st.executeQuery(sql)) {
//			ResultSetMetaData md = rs.getMetaData();
//			int cols = md.getColumnCount();
			while (rs.next()) {
//				for (int i = 1; i <= cols; i++) {
//					sb.append(rs.getString(i));
//					if (i < cols) sb.append(",                 ");
//				}
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				sb.append(rs.getInt(1) + " " + rs.getString(2));
			}
		}
		return sb.toString();
	}

	public void getData2(String sql) throws SQLException {
		Connection con = ds.getConnection();
		try {
			
			 Statement st = con.createStatement();
			 int rows = st.executeUpdate(sql);
			 System.out.println("rows" + rows);
		}
		finally {
			con.close();
		}
	}
}