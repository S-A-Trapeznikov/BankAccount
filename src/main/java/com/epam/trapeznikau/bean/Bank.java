package com.epam.trapeznikau.bean;

import java.util.HashSet;
import java.util.Set;

public class Bank {	
		
	private Set<Customer> customers;
	private Set<BankAccount> accounts;
	
	public Bank(){
		customers = new HashSet<Customer>();
		accounts = new HashSet<BankAccount>();
	}
	
	public Boolean addCustomer(Customer customer){
		return customers.add(customer);
	}
	
	public Boolean addAccount(BankAccount account){
		return accounts.add(account);
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
