package com.cg.dao;

public interface LoanDAOInterface {
	
	void createAccount(String accountNum,String password, String name, String gender);
	void logIn(String accountNum,String password);
	
	void applyLoan(String accountNum,double loanAmount,int time);
	void showBal(String accountNum);
	void payEmi(String accountNum);
	void foreClose(String accountNum);
	void calEmi();
	void printTransactions(String accountNum);
}
