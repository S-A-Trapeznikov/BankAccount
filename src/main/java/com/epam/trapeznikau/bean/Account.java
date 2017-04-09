package com.epam.trapeznikau.bean;

public abstract class Account {
		
	String accNum;
	Long balance;
	
	public Account(){};
	
	public Account(String accNum, Long balance){
		this.accNum = accNum;
		this.balance = balance;
	}	
	
	public  abstract void setAccNum(String accNum);
	
	public abstract void setBalance(Long balance);
	
	public abstract String getAccNum();
	
	public abstract Long getBalance();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		if (accNum == null) {
			if (other.accNum != null) {
				return false;
			}
		} else if (!accNum.equals(other.accNum)) {
			return false;
		}
		if (balance == null) {
			if (other.balance != null) {
				return false;
			}
		} else if (!balance.equals(other.balance)) {
			return false;
		}
		return true;
	}
	
	

}
