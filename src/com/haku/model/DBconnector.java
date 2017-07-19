package com.haku.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {

	private static DBconnector instance = new DBconnector();

	private DBconnector() {

	}

	public static DBconnector getInstance() {
		return instance;
	}

	public Connection getConnecion() {
		Connection connection = null;
		String dbUrl = "jdbc:mysql://localhost:3306/shortstory";
		String dbUserName = "root";
		String dbPassWord = "buiquangcuong";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		} catch (ClassNotFoundException e) {
			System.out.println("Connect DB: Error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connect DB: Error");
			e.printStackTrace();
		}
		return connection;

	}

	public static boolean closeConnection(Connection connection) {
		if (connection == null)
			return false;
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("close connection: Error");
		}
		System.out.println("close connection: Error");
		return false;

	}

}
