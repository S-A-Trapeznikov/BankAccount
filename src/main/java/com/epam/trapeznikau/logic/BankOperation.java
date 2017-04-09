package com.epam.trapeznikau.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.trapeznikau.bean.Bank;
import com.epam.trapeznikau.bean.BankAccount;
import com.epam.trapeznikau.bean.Customer;
import com.epam.trapeznikau.utility.Utility;

public class BankOperation {

	private BankOperation() {
	}

	final static Logger logger = LogManager.getLogger("BanOperations.class");

	public static boolean addNewCustomer(Bank bank, String firstName, String secondName, String thirdName,String accountType, Long balance, Boolean accStatus,Float percent, Date dateBegin, Date dateEnd) {
		String accNum = Utility.newAccNum();
		Customer customer = new Customer(firstName, secondName, thirdName);
		Integer idCustomer = customer.getIdCustomer();
		BankAccount account = AccountFactory.createAccount(accountType);
		switch (accountType.toUpperCase()){
		case "CREDIT": Utility.fillAccountFields(account, accNum, balance, accStatus, idCustomer,percent,dateBegin,dateEnd);
		case "DEPOZIT":Utility.fillAccountFields(account, accNum, balance, accStatus, idCustomer,percent,dateBegin,dateEnd);
		case "ACCOUNT":Utility.fillAccountFields(account, accNum, balance, accStatus, idCustomer);
		}		
		bank.addAccount(account);
		customer.addNewAccount(account);
		return bank.addCustomer(customer);
	}

	public static void addNewCustomers(Bank bank, ArrayList<String> str){
		
		Iterator<String> it = str.iterator();
		while (it.hasNext()){
			String [] acc;
			acc = it.next().split(";");
			String accNum = Utility.newAccNum();
			Customer customer = new Customer(acc[0], acc[1], acc[2]);
			Integer idCustomer = customer.getIdCustomer();
			BankAccount account = AccountFactory.createAccount(acc[3]);
			switch (acc[3].toUpperCase()){
			case "CREDIT": Utility.fillAccountFields(account,accNum,acc[4],acc[5],idCustomer, acc[6], acc[7],acc[8]);
			case "DEPOZIT":Utility.fillAccountFields(account,accNum,acc[4],acc[5],idCustomer, acc[6], acc[7],acc[8]);
			case "ACCOUNT":Utility.fillAccountFields(account,accNum,acc[4],acc[5],idCustomer);
			}
			bank.addAccount(account);
			customer.addNewAccount(account);
			bank.addCustomer(customer);
		}
			
	}

	public static String accessAccVerify(Bank bank, String numAcc) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		BankAccount account;
		String value = "";
		while (iterator.hasNext()) {
			account = iterator.next();
			if (account.getAccNum().equals(numAcc) && (account.getStatus() == true))
				value = "AVAILABLE";
			if (account.getAccNum().equals(numAcc) && (account.getStatus() == false))
				value = "BLOCK";
		}
		return value;
	}

	public static String switchAccessAccStatus(Bank bank, String numAcc) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		BankAccount account;
		String value = "";
		while (iterator.hasNext()) {
			account = iterator.next();
			if (account.getAccNum().equals(numAcc)) {
				account.setStatus(false);
				value = "BLOCKED";
			}
		}

		return value;
	}

	public static String findAccount(Bank bank, String numAcc) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		BankAccount account;
		String value = "NOT FOUND";
		while (iterator.hasNext()) {
			account = iterator.next();
			if (account.getAccNum().equals(numAcc))
				value = account.toString();
		}
		return value;

	}

	public static List<BankAccount> sortAccount(Bank bank) {
		List<BankAccount> accounts = new LinkedList<BankAccount>(bank.getAccounts());
		Collections.sort(accounts, Utility.BankAccountComparator);
		return accounts;
	}

	public static List<BankAccount> sortIdAccount(Bank bank) {
		List<BankAccount> accounts = new LinkedList<BankAccount>(bank.getAccounts());
		Collections.sort(accounts, Utility.BankAccountIdComparator);
		return accounts;
	}

	public static List<BankAccount> sortBalanceAccount(Bank bank) {
		List<BankAccount> accounts = new LinkedList<BankAccount>(bank.getAccounts());
		Collections.sort(accounts, Utility.BankAccountBalanceComparator);
		return accounts;
	}

	public static Long totalValueAccounts(Bank bank) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		Long total = 0L;
		BankAccount account;
		while (iterator.hasNext()) {
			account = iterator.next();
			total = total + account.getBalance();
		}
		return total;
	}

	public static Long totalValueDebtAccounts(Bank bank) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		Long total = 0L;
		BankAccount account;
		while (iterator.hasNext()) {
			account = iterator.next();
			if (account.getBalance() < 0)
				total = total + account.getBalance();
		}
		return total;
	}

	public static Long totalValueCreditAccounts(Bank bank) {
		Set<BankAccount> accounts = bank.getAccounts();
		Iterator<BankAccount> iterator = accounts.iterator();
		Long total = 0L;
		BankAccount account;
		while (iterator.hasNext()) {
			account = iterator.next();
			if (account.getBalance() > 0)
				total = total + account.getBalance();
		}
		return total;
	}

}
