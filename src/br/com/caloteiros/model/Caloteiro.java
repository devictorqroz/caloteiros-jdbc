package br.com.caloteiros.model;

import java.util.Calendar;

public class Caloteiro {
	
	private Long id;
	private String name;
	private String email;
	private Integer debt;
	private Calendar debtDate;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getDebt() {
		return debt;
	}
	
	public void setDebt(Integer debt) {
		this.debt = debt;
	}
	
	public Calendar getDebtDate() {
		return debtDate;
	}
	
	public void setDateDebt(Calendar debtDate) {
		this.debtDate = debtDate;
	}
	
}
