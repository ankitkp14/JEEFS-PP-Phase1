package com.cg.ui;

import java.util.Scanner;

import com.cg.bean.Account;
import com.cg.bean.ServiceRepository;
import com.cg.service.LoanServiceImpl;

public class LoanMenu {
	public static void loginMenu(String accountNum) {
		
		Scanner scan1=new Scanner(System.in);
		
		LoanServiceImpl module=new LoanServiceImpl();
		Account account;
		
		module.print(accountNum);
		System.out.println("\n\n*******Our Services********");
		System.out.println("\n\n1.Apply Loan		2.ForeClose\n3.Show Balance		4.Print Transactions\n5.Pay EMI		6.Calculate EMI\n7.Logout\n\nEnter Choice:");
		
		
		int choice=0;
		
		try {
		choice=scan1.nextInt();
		}
		catch(Exception e) {
			System.out.println("\nWrong choice !!..Try again");
			loginMenu(accountNum);
		}
		
		switch(choice) {
		case 1:
			
			System.out.print("\nEnter Amount you wish to apply for: ");
			double loanAmount=scan1.nextDouble();
			
			System.out.println("Enter number of months for repayment\n(Choose from the options)\n6 Month\n12 Month\n24 Month\n36 Month\n60 Month\n120 Month");
			int time=scan1.nextInt();
			
			while(!(time==6 || time==12 || time==24 || time==36 || time==60 || time==120)) {
				System.out.println("\nWrong duration..Try again");
				time=scan1.nextInt();
			}
			
			module.applyLoan(accountNum,loanAmount,time);
			loginMenu(accountNum);
			break;
			
		case 2:
			
			account=ServiceRepository.repository.get(accountNum);
			double balance=account.getLoanBal();
			double foreCloseAmount=balance+balance*0.04;
			
			System.out.println("Your foreclosure amount is: "+foreCloseAmount);
			System.out.print("\nType the above amount to pay the loan: ");
			double validateAmount=scan1.nextDouble();
			
			module.foreClose(accountNum,validateAmount);
			loginMenu(accountNum);
			break;
			
		case 3:
			
			module.showBal(accountNum);
			loginMenu(accountNum);
			break;
			
		case 4:
			
			module.printTransactions(accountNum);
			loginMenu(accountNum);
			break;
			
		case 5:
			
			account=ServiceRepository.repository.get(accountNum);
			
			System.out.println("\nYour loan balance is :"+account.getLoanBal());
			System.out.println("\nYour current emi is :"+account.getEmi());
			
			System.out.print("\nEnter the EMI amount to pay: ");
			double emi=scan1.nextDouble();
			
			module.payEmi(accountNum,emi);
			loginMenu(accountNum);
			break;
			
		case 6:
			
			System.out.print("\nEnter the Amount of Loan:");
			double amount=scan1.nextDouble();
			
			module.calEmi(amount);
			loginMenu(accountNum);
			
			break;
			
		case 7:
			
			new MainMenu().startApp();
			break;
			
		default:
			
			System.out.println("\nWrong Option..Try Again!!");
			loginMenu(accountNum);
			break;
			
		}
		scan1.close();
	}
}
