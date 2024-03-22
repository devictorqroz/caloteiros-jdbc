package br.com.caloteiros.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionJDBC {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Test Connection!");

		connection.close();
	}

}
