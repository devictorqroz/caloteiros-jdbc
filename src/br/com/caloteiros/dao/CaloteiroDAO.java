package br.com.caloteiros.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caloteiros.jdbc.ConnectionFactory;
import br.com.caloteiros.model.Caloteiro;

public class CaloteiroDAO {

	private Connection connection;
	
	
	public CaloteiroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void add(Caloteiro caloteiro) {
		String stmt = "insert into caloteiro " +
				"(name, email, debt, dateDebt) " +
				"values (?,?,?,?)";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(stmt);
			
			pstmt.setString(1, caloteiro.getName());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDebt());
			pstmt.setDate(4, new Date(caloteiro.getDateDebt().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
