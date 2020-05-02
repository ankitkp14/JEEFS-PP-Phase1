package com.cg.dao;

import com.cg.bean.Account;

public interface ILoanDAO {
	
	void createAccount(String accountNum,String password, String name, String gender);
	boolean logIn(String accountNum,String password);
	
	void applyLoan(String accountNum,double loanAmount,int time);
	Account showBal(String accountNum);
	void payEmi(String accountNum,double emi);
	void foreClose(String accountNum,double validateAmount);
	double calEmi(double amount,double duration);
	void printTransactions(String accountNum);
}
