
package com.epam.trapeznikau.logic;

import com.epam.trapeznikau.bean.BankAccount;
import com.epam.trapeznikau.bean.CreditBankAccount;
import com.epam.trapeznikau.bean.DepozitBankAccount;

public final class AccountFactory {
	
	private AccountFactory(){}
	
	public static BankAccount createAccount(String accountType){
		
		if (accountType.toUpperCase().equals("DEPOZIT")) { return new DepozitBankAccount();}
		if (accountType.toUpperCase().equals("ACCOUNT")) { return new BankAccount();}
		if (accountType.toUpperCase().equals("CREDIT")) { return new CreditBankAccount();}
		
		return null;
	}
	

}
