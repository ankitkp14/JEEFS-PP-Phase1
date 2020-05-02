package com.cg.dao;

import com.cg.bean.Account;
import com.cg.bean.ServiceRepository;

public class LoanDAOImpl implements ILoanDAO {

	Account account=new Account();
	
	@Override
	public void applyLoan(String accountNum,double loanAmount,int time) {
		
		account=ServiceRepository.repository.get(accountNum);
		
		double RATE=10;
		double emi=Math.round((loanAmount * Math.pow((1+RATE/100),time/12))/time);
		
		account.setLoanBal(emi*time);
		account.setLoanAmount(loanAmount);
		account.setDuration(time);
		account.setEmi(emi);
		
		account.setStatement("* Loan applied for the amount :"+loanAmount+" for "+time+" months.");
		
	}

	@Override
	public Account showBal(String accountNum) {
		
		account=ServiceRepository.repository.get(accountNum);
		return account;
		
	}

	@Override
	public void payEmi(String accountNum,double emi) {
		
		account=ServiceRepository.repository.get(accountNum);
		double newBal=account.getLoanBal()-account.getEmi();
		account.setLoanBal(newBal);
		account.setStatement("* Paid emi amount :"+emi+". Updated loan balance is Rs. "+newBal+".");
		
	}

	@Override
	public void foreClose(String accountNum,double validateAmount) {
		
		account=ServiceRepository.repository.get(accountNum);
		account.setLoanBal(0);
		account.setStatement("* Loan foreclosure initiated..Successfully paid whole amount.");
		
	}

	@Override
	public double calEmi(double amount,double duration) {
		
		double RATE=10;
		double emi=Math.round((amount * Math.pow((1+RATE/100),duration/12))/duration);
		return emi;
	}

	@Override
	public void printTransactions(String accountNum) {
		
		account=ServiceRepository.repository.get(accountNum);
		account.getStatement().forEach(System.out::println);

	}

	@Override
	public void createAccount(String accountNum, String password, String name, String gender) {
		
		Account account=new Account(accountNum,password,name,gender);
		ServiceRepository.repository.put(accountNum,account);
	}

	@Override
	public boolean logIn(String accountNum, String password) {
		
		if(ServiceRepository.repository.containsKey(accountNum) && ServiceRepository.repository.get(accountNum).getPassword().equals(password)){
			return true;
		}
		else {
			return false;
		}
	}

}
