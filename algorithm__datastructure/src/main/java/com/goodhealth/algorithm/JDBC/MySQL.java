package com.goodhealth.algorithm.JDBC;

import java.sql.*;

public class MySQL {

	private static final int port=3306;
	private static final String databaseName="mystore";
	private static final String URL ="jdbc:mysql://localhost:"+port+"/"+databaseName;
	private static final String USER = "root";
	private static final String PWD = "root"; 
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void getConn() {
		Connection conn = null ;
		Statement stmt ;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			stmt = conn.createStatement();
			String sql = "select * from user";
		       rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("logname");
				String pwd = rs.getString("password");
				System.out.println(id + "," + pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		MySQL mySQLConnection = new MySQL();
		mySQLConnection.getConn();
	}
}
