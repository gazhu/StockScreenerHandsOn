package com.ey.wamacademy.capstoneapi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static DbConnection db = new DbConnection();

	private DbConnection() {

	}

	public static DbConnection getObject() {

		return db;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockscreener", "root", "87654321");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}

}
