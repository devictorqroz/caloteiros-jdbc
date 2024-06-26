package br.com.caloteiros.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caloteiros.jdbc.ConnectionFactory;
import br.com.caloteiros.model.Caloteiro;

public class CaloteiroDAO {

	private Connection connection;


	public CaloteiroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}


	public void add(Caloteiro caloteiro) {
		String stmt = "insert into caloteiro " +
				"(name, email, debt, debtDate) " +
				"values (?,?,?,?)";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(stmt);

			pstmt.setString(1, caloteiro.getName());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDebt());
			pstmt.setDate(4, new Date(caloteiro.getDebtDate().getTimeInMillis()));

			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Caloteiro> getList() {
		try {
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from caloteiro;");

			List<Caloteiro> caloteiros = new ArrayList<>();
			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Long idCaloteiro = (long) rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int debt = rs.getInt("debt");
				Calendar debtDate = Calendar.getInstance();
				debtDate.setTime(rs.getDate("debtDate"));

				caloteiro = new Caloteiro();

				caloteiro.setId(idCaloteiro);
				caloteiro.setName(name);
				caloteiro.setEmail(email);
				caloteiro.setDebt(new Integer(debt));
				caloteiro.setDebtDate(debtDate);

				caloteiros.add(caloteiro);
			}

			rs.close();
			stmt.close();
			return caloteiros;

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void update(Caloteiro caloteiro) {
		String sql = "update caloteiro set name=?, email=?,"+
				"debt=?, debtDate=? where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, caloteiro.getName());
			stmt.setString(2, caloteiro.getEmail());
			stmt.setInt(3, caloteiro.getDebt());
			stmt.setDate(4, new Date(caloteiro.getDebtDate().getTimeInMillis()));
			stmt.setLong(5, caloteiro.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void delete(Caloteiro caloteiro) {
		String sql = "delete from caloteiro where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setLong(1, caloteiro.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public Caloteiro getCaloteiro(Long id) {
		try {
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from caloteiro where id=?");
			stmt.setLong(1, id);

			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				Long idCaloteiro = rs.getLong("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int debt = rs.getInt("debt");
				Calendar debtDate = Calendar.getInstance();
				debtDate.setTime(rs.getDate("debtDate"));

				caloteiro = new Caloteiro();

				caloteiro.setId(idCaloteiro);
				caloteiro.setName(name);
				caloteiro.setEmail(email);
				caloteiro.setDebt(new Integer(debt));
				caloteiro.setDebtDate(debtDate);
			}

			rs.close();
			stmt.close();
			return caloteiro;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}




