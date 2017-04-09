package com.epam.trapeznikau.bean;


import java.util.HashSet;
import java.util.Set;

public class Customer {
			
	private static int id;
	private Integer idCustomer;
	private String firstName;
	private String secondName;
	private String thirdName;
	private Set<BankAccount> accounts;
	
	
	public Customer(String firstName,String secondName,String thirdName){
		id++;
		idCustomer = id;
		this.firstName=firstName;
		this.secondName = secondName;
		this.thirdName = thirdName;
		accounts = new HashSet<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getThirdName() {
		return thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public Set<BankAccount> getAccounts() {
		return accounts;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}
	
	public Boolean addNewAccount(BankAccount account){
		return accounts.add(account);
		
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", thirdName=" + thirdName + ", accounts=" + accounts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idCustomer == null) ? 0 : idCustomer.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((thirdName == null) ? 0 : thirdName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {	if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Customer other = (Customer) obj;
		if (accounts == null) {	if (other.accounts != null)	return false;
		} else if (!accounts.equals(other.accounts)) return false;
		if (firstName == null) {if (other.firstName != null) return false;
		} else if (!firstName.equals(other.firstName)) return false;
		if (idCustomer == null) {if (other.idCustomer != null) return false;
		} else if (!idCustomer.equals(other.idCustomer)) return false;
		if (secondName == null) {if (other.secondName != null) return false;
		} else if (!secondName.equals(other.secondName)) return false;
		if (thirdName == null) {if (other.thirdName != null) return false;
		} else if (!thirdName.equals(other.thirdName)) return false;
		return true;
	}

	

	
	
	
	
	
	
}
