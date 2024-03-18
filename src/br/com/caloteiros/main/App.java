package br.com.caloteiros.main;

import java.util.Calendar;
import java.util.List;

import br.com.caloteiros.dao.CaloteiroDAO;
import br.com.caloteiros.model.Caloteiro;

public class App {

	public static void main(String[] args) {
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setName("Mark Doe");
		caloteiro.setEmail("markdoe@email.com");
		caloteiro.setDebt(200);
		caloteiro.setDebtDate(Calendar.getInstance());

		CaloteiroDAO dao = new CaloteiroDAO();
		dao.add(caloteiro);
		
		System.out.println("Registered!");
		
		List<Caloteiro> list = dao.getList();
		
		for(Caloteiro c : list) {
			System.out.println("Name: " + c.getName());
			System.out.println("Emal: " + c.getEmail());
			System.out.println("Debt: $" + c.getDebt());
			System.out.println("Date: " + c.getDebtDate().getTime() + "\n");
		}
		
	}

}
