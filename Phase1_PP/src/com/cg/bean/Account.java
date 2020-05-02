package com.cg.bean;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private String accountNum;
	private String password;
	
	private String name;
	private String gender;
	
	private double loanAmount;
	private double loanBal;
	private double emi;
	private int duration;
	
	private List<String> statement=new ArrayList<>();
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountNum, String password, String name, String gender) {
		
		this.accountNum = accountNum;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}
	
	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public double getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(double loanBal) {
		this.loanBal = loanBal;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	public List<String> getStatement() {
		return statement;
	}
	
	public void setStatement(String newStatement) {
		this.statement.add(newStatement);
	}
}
