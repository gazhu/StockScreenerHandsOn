package com.ey.wamacademy.capstoneapi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Establishes connection with MySql database and then returns connection object to LandingPageDao
public class DbConnection {

	private static DbConnection db = new DbConnection();

	// private constructor so that it cannot be invoked outside the class
	private DbConnection() {

	}
	
	/**
	 * public method to provide class instance
	 *
	 * @return class instance
	 */
	public static DbConnection getObject() {

		return db;
	}

	/**
	 * for establishing connection with database
	 *
	 * @return Connection object
	 */
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
