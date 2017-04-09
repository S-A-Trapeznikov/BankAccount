package com.epam.trapeznikau.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.trapeznikau.bean.BankAccount;
import com.epam.trapeznikau.bean.CreditBankAccount;
import com.epam.trapeznikau.bean.DepozitBankAccount;

public class Utility {
	
	final static Logger logger = LogManager.getLogger("AccountUtility.class");
	
	public static String newAccNum(){
		Integer first = 0;
		Integer last = 9;
		Integer num;
		String accNum ="";
		for (int i=0;i<12;i++){
			num = first +(int)(Math.random()*last);
			accNum = accNum+num;
		}
		return accNum;
		
	}
	
	public static Date dateOf(String dateStr) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			logger.error("Cannot parse");
		}
		return date;

	}
	
	public static BankAccount fillAccountFields(BankAccount account, String accNum, String balance, String accStatus,Integer idCustomer) {
		account.setAccNum(accNum);
		account.setBalance(Long.valueOf(balance));
		account.setStatus(Boolean.valueOf(accStatus));
		account.setIdCustomer(idCustomer);
		return account;
	}

	public static BankAccount fillAccountFields(BankAccount account, String accNum, Long balance, Boolean accStatus,Integer idCustomer) {
		account.setAccNum(accNum);
		account.setBalance(balance);
		account.setStatus(accStatus);
		account.setIdCustomer(idCustomer);
		return account;
	}

	public static BankAccount fillAccountFields(BankAccount account, String accNum, String balance, String accStatus, Integer idCustomer, String percent, String dateBegin, String dateEnd) {
		account.setAccNum(accNum);
		account.setBalance(Long.valueOf(balance));
		account.setStatus(Boolean.valueOf(accStatus));
		account.setIdCustomer(idCustomer);
		if (account instanceof DepozitBankAccount) {
			((DepozitBankAccount) account).setBeginDepozit(Utility.dateOf(dateBegin));
			((DepozitBankAccount) account).setEndDepozit(Utility.dateOf(dateEnd));
			((DepozitBankAccount) account).setPercent(Float.valueOf(percent));
		}
		if (account instanceof CreditBankAccount) {
			((CreditBankAccount) account).setBeginCredit(Utility.dateOf(dateBegin));
			((CreditBankAccount) account).setEndCredit(Utility.dateOf(dateEnd));
			((CreditBankAccount) account).setPercent(Float.valueOf(percent));
		}
		return account;
	}
	
	public static BankAccount fillAccountFields(BankAccount account, String accNum, Long balance, Boolean accStatus, Integer idCustomer, Float percent, Date dateBegin, Date dateEnd) {
		account.setAccNum(accNum);
		account.setBalance(balance);
		account.setStatus(accStatus);
		account.setIdCustomer(idCustomer);
		if (account instanceof DepozitBankAccount) {
			((DepozitBankAccount) account).setBeginDepozit(dateBegin);
			((DepozitBankAccount) account).setEndDepozit(dateEnd);
			((DepozitBankAccount) account).setPercent(percent);
		}
		if (account instanceof CreditBankAccount) {
			((CreditBankAccount) account).setBeginCredit(dateBegin);
			((CreditBankAccount) account).setEndCredit(dateEnd);
			((CreditBankAccount) account).setPercent(percent);
		}
		return account;
	}

	
	public static Comparator<BankAccount> BankAccountComparator = new Comparator<BankAccount>() {

		public int compare(BankAccount o1, BankAccount o2) {
			int result = o1.getAccNum().compareTo(o2.getAccNum());
			if (result != 0) {
				return result;
			}
			return 0;
		}
	};
	
	public static Comparator<BankAccount> BankAccountBalanceComparator = new Comparator<BankAccount>() {

		public int compare(BankAccount o1, BankAccount o2) {
			int result = (int) (o1.getBalance() - o2.getBalance());
			if (result != 0) {
				return result / Math.abs(result);
			}			
			return 0;
		}
	};
	
	public static Comparator<BankAccount> BankAccountIdComparator = new Comparator<BankAccount>() {

		public int compare(BankAccount o1, BankAccount o2) {
			int result = o1.getIdCustomer() - o2.getIdCustomer();
			if (result != 0) {
				return (int) (result / Math.abs(result));
			}
			return 0;
		}
	};
	
	

}
