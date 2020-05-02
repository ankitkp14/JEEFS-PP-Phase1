package com.cg.service;

import java.io.IOException;

import com.cg.bean.Account;
import com.cg.bean.ServiceRepository;
import com.cg.dao.LoanDAOImpl;
import com.cg.ui.LoanMenu;
import com.cg.ui.MainMenu;

public class LoanServiceImpl implements ILoanService {
	
	Account account=new Account();
	LoanDAOImpl dao;
	
	public LoanServiceImpl() {
		dao=new LoanDAOImpl();
	}
	
	@Override
	public void applyLoan(String accountNum,double loanAmount,int time){
		
		account=ServiceRepository.repository.get(accountNum);
		
		if(account.getLoanBal()>0) {
			System.out.println("Can't apply for another loan...already taken !!");
		}
		else {
			dao.applyLoan(accountNum, loanAmount, time);
			System.out.println("\nYour loan has been applied !!");
		}
		
		System.out.print("\nPress any key to continue:");
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showBal(String accountNum) {
		
		account=dao.showBal(accountNum);
		System.out.print("\n\nApplied Amount: "+account.getLoanAmount());
		System.out.print("\tCurrent Loan Balance: "+account.getLoanBal());
		System.out.print("\tCurrent EMI: "+account.getEmi());
		
		System.out.print("\nPress any key to continue:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void payEmi(String accountNum,double emi) {
		
		account=ServiceRepository.repository.get(accountNum);
		
		if(account.getEmi()!=0 && emi==account.getEmi()) {
			dao.payEmi(accountNum,emi);
			System.out.println("\nYour EMI is paid successfully!!");
		}
		else {
			System.out.println("\nEMI value incorrect or No emi exists..");
			LoanMenu.loginMenu(accountNum);
		}
		
		System.out.print("\nPress any key to continue:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void foreClose(String accountNum,double validateAmount) {
		
		account=ServiceRepository.repository.get(accountNum);
		double balance=account.getLoanBal();

		double foreCloseAmount=balance+balance*0.04;

		if(foreCloseAmount==validateAmount) {
			dao.foreClose(accountNum,validateAmount);
			System.out.println("\nYour Loan is cleared successfully!!");
		}
		else {
			System.out.print("Enter correct closure amount !! ");
			foreClose(accountNum,validateAmount);
		}
		
		System.out.print("\nPress any key to continue:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void calEmi(double amount) {
		
		double emi=dao.calEmi(amount,6);
		System.out.println("\nAmount: "+amount+"      No. of Months: 6"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		emi=dao.calEmi(amount,12);
		System.out.println("\nAmount: "+amount+"      No. of Months: 12"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		emi=dao.calEmi(amount,24);
		System.out.println("\nAmount: "+amount+"      No. of Months: 24"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		emi=dao.calEmi(amount,36);
		System.out.println("\nAmount: "+amount+"      No. of Months: 36"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		emi=dao.calEmi(amount,60);
		System.out.println("\nAmount: "+amount+"      No. of Months: 60"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		emi=dao.calEmi(amount,120);
		System.out.println("\nAmount: "+amount+"      No. of Months: 120"+"       ROI: "+10+"%\nEMI :  "+emi);
		
		System.out.print("\nPress any key to continue:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printTransactions(String accountNum) {
		
		System.out.println("\n\nLoan Statement\n");
		dao.printTransactions(accountNum);
		
		System.out.print("\nPress any key to continue:");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createAccount(String accountNum, String password, String name, String gender) {
		dao.createAccount(accountNum, password, name, gender);
		System.out.println("\n\nYour Account has been created Successfully !!");
		new MainMenu().startApp();
	}

	@Override
	public boolean logIn(String accountNum, String password) {
		
		if(dao.logIn(accountNum, password)) {
			return true;
		}
		return false;
	}

	@Override
	public void print(String accountNum) {
		
		account=ServiceRepository.repository.get(accountNum);
		System.out.print("\nName :"+account.getName());
		System.out.print("\tAccount Number :"+account.getAccountNum());
		System.out.println("\tGender :"+account.getGender());
		
	}
	
	public boolean checkUserId(String accountNum) {
		String checkAccNum="([0-9]+)";
		
		if(accountNum.matches(checkAccNum) && accountNum.length()>=11) return true;
		return false;
	}
	
	public boolean checkPass(String password) {
		String checkPassword="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		
		if(password.matches(checkPassword)) return true;
		return false;
	}
	
	public boolean checkName(String name) {
		String checkname="([A-Za-z_ ]+)";
		
		if(name.matches(checkname)) return true;
		return false;
	}
}
