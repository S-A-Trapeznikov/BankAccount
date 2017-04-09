package com.epam.trapeznikau.runner;

import java.util.ArrayList;

import com.epam.trapeznikau.bean.Bank;
import com.epam.trapeznikau.bean.Customer;
import com.epam.trapeznikau.dao.DataReader;
import com.epam.trapeznikau.logic.BankOperation;
import com.epam.trapeznikau.view.ConsoleView;

public class Runner {
	
	public static void main (String args[]){
		Bank bank = new Bank();
		ArrayList<String> str = DataReader.readData("resources/Customers.txt");
		BankOperation.addNewCustomers(bank,str);
//		BankOperation.addNewCustomer(bank, "Sergei", "Ivanov", "Ivanovich","Depozit", 300L, true);
//		BankOperation.addNewCustomer(bank, "Danila", "Lutikov", "Ivanovich","Credit", -200000L, true);
//		BankOperation.addNewCustomer(bank, "Andrei", "Ivanov", "Antonovich","Account", -310L, true);
//		BankOperation.addNewCustomer(bank, "Artem", "Petrov", "Urevich","Depozit", 10000L, true);
		ConsoleView.printListAccount(bank);
		ConsoleView.print(BankOperation.sortAccount(bank));
		ConsoleView.print(BankOperation.sortIdAccount(bank));
		ConsoleView.print(BankOperation.sortBalanceAccount(bank));
		System.out.println(BankOperation.totalValueAccounts(bank));	
		System.out.println(BankOperation.totalValueCreditAccounts(bank));
		System.out.println(BankOperation.totalValueDebtAccounts(bank));
	}

}
