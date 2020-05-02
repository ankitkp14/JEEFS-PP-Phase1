package com.cg.service;

public interface ILoanService {
	
	void createAccount(String accountNum,String password, String name, String gender);
	boolean logIn(String accountNum,String password);
	
	void applyLoan(String accountNum,double loanAmount,int time);
	void showBal(String accountNum);
	void payEmi(String accountNum,double emi);
	void foreClose(String accountNum,double validateAmount);
	void calEmi(double amount);
	void printTransactions(String accountNum);
	void print(String accountNum);
}
