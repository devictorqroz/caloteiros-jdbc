package br.com.caloteiros.main;

import java.util.Calendar;
import java.util.List;

import br.com.caloteiros.dao.CaloteiroDAO;
import br.com.caloteiros.model.Caloteiro;

public class App {

	public static void main(String[] args) {
				
		Caloteiro carlo = new Caloteiro(); 
		carlo.setName("Carlo");
		carlo.setEmail("carlo@email.com"); 
		carlo.setDebt(800);
		carlo.setDebtDate(Calendar.getInstance());
		
		Caloteiro barzini = new Caloteiro(); 
		barzini.setName("Barzini");
		barzini.setEmail("barzini@email.com"); 
		barzini.setDebt(500);
		barzini.setDebtDate(Calendar.getInstance());
		
		Caloteiro moe = new Caloteiro(); 
		moe.setName("Moe Greene");
		moe.setEmail("moegreene@email.com"); 
		moe.setDebt(400);
		moe.setDebtDate(Calendar.getInstance());
 
		Caloteiro sollozzo = new Caloteiro(); 
		sollozzo.setName("Sollozzo");
		sollozzo.setEmail("sollozzo@email.com"); 
		sollozzo.setDebt(300);
		sollozzo.setDebtDate(Calendar.getInstance());
		
		Caloteiro roth = new Caloteiro(); 
		roth.setName("Hyman Roth");
		roth.setEmail("hymanroth@email.com"); 
		roth.setDebt(500);
		roth.setDebtDate(Calendar.getInstance());
		
		
		CaloteiroDAO dao = new CaloteiroDAO(); 
		dao.add(carlo);
		dao.add(barzini);
		dao.add(moe);
		dao.add(sollozzo);
		dao.add(roth);
		
		
		List<Caloteiro> list = null;
		
		
		System.out.println("################################ \n");
		
		System.out.println("Registered! \n");
		
		System.out.println("################################ \n");
		
		list = dao.getList();
		
		for(Caloteiro c : list) {
			System.out.println("ID: " + c.getId());
			System.out.println("Name: " + c.getName());
			System.out.println("Emal: " + c.getEmail());
			System.out.println("Debt: $" + c.getDebt());
			System.out.println("Date: " + c.getDebtDate().getTime() + "\n");
		}
		
		
		System.out.println("################################ \n");
		
		Caloteiro caloteiroUpdated = list.get(2);
		caloteiroUpdated.setDebt(900);
		System.out.println("Name: " + caloteiroUpdated.getName());
		dao.update(caloteiroUpdated);
		System.out.println("Updated! \n");
		
		list = dao.getList();
		
		for(Caloteiro c : list) {
			System.out.println("ID: " + c.getId());
			System.out.println("Name: " + c.getName());
			System.out.println("Emal: " + c.getEmail());
			System.out.println("Debt: $" + c.getDebt());
			System.out.println("Date: " + c.getDebtDate().getTime() + "\n");
		}
		
		
		System.out.println("################################ \n");
		
		
		Caloteiro caloteiroDeleted = list.get(0);
		System.out.println("Name: " + caloteiroDeleted.getName());
		dao.delete(caloteiroDeleted);
		System.out.println("Deleted! \n");
	
		list = dao.getList();
		
		for(Caloteiro c : list) {
			System.out.println("ID: " + c.getId());
			System.out.println("Name: " + c.getName());
			System.out.println("Emal: " + c.getEmail());
			System.out.println("Debt: $" + c.getDebt());
			System.out.println("Date: " + c.getDebtDate().getTime() + "\n");
		}
		
		
		System.out.println("################################ \n");
		
		Caloteiro caloteiroSearched = dao.getCaloteiro(list.get(1).getId());
		System.out.println("ID: " + caloteiroSearched.getId());
		System.out.println("Name: " + caloteiroSearched.getName());
		System.out.println("Emal: " + caloteiroSearched.getEmail());
		System.out.println("Debt: $" + caloteiroSearched.getDebt());
		System.out.println("Date: " + caloteiroSearched.getDebtDate().getTime() + "\n");	
	}
}
