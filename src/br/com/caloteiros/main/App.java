package br.com.caloteiros.main;

import java.util.Calendar;

import br.com.caloteiros.dao.CaloteiroDAO;
import br.com.caloteiros.model.Caloteiro;

public class App {

	public static void main(String[] args) {
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setName("John Doe");
		caloteiro.setEmail("johndoe@email.com");
		caloteiro.setDebt(100);
		caloteiro.setDateDebt(Calendar.getInstance());

		CaloteiroDAO dao = new CaloteiroDAO();
		dao.add(caloteiro);
		
		System.out.println("Registered!");
	}

}
