package com.epam.trapeznikau.view;

import java.util.Collection;
import java.util.Set;

import com.epam.trapeznikau.bean.Bank;
import com.epam.trapeznikau.bean.BankAccount;
import com.epam.trapeznikau.bean.Customer;

public final class ConsoleView {
	
	private ConsoleView(){};
	
	public static void print(Collection<BankAccount> collection){
		for (BankAccount account: collection)
			System.out.println(account.toString());
	}
	
	public static void printListAccount(Bank bank){
		for (BankAccount account: bank.getAccounts())
			System.out.println(account.toString());
	}
	
	public static void printListCustomers(Bank bank){
		for (Customer customer: bank.getCustomers())
			System.out.println(customer.toString());
	}

}
