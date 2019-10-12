package com.goodhealth.algorithm.JDBC;

import java.sql.*;

public class Oracle {
	
	private static final int port = 1521;
	private static final String databaseName = "ghj";
	private static final String URL = "jdbc:oracle:thin:@localhost:" + port + ":" + databaseName;
	private static final String USER = "sa";
	private static final String PWD = "123456";

	public void getConn() throws SQLException {
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			stmt = conn.createStatement();
			String sql = "select * from Admin";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("Pwd");
				System.out.println(id + "," + pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
			}
		}
	}

	public static void main(String[] args) {
		Oracle oracleConnection = new Oracle();
		try {
			oracleConnection.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
