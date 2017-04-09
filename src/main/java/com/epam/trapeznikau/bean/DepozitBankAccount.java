package com.epam.trapeznikau.bean;

import java.util.Date;

public class DepozitBankAccount extends BankAccount {
	
	private Float percent;
	private Date beginDepozit;
	private Date endDepozit;
	
	public DepozitBankAccount (){
		super();
	}
	
	public DepozitBankAccount (String accNum, Long balance, Integer idCustomer, Boolean status, Float percent, Date beginDepozit, Date endDepozit){
		super(accNum, balance, idCustomer, status);
		this.percent = percent;
		this.beginDepozit = beginDepozit;
		this.endDepozit = endDepozit;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public Date getBeginDepozit() {
		return beginDepozit;
	}

	public void setBeginDepozit(Date beginDepozit) {
		this.beginDepozit = beginDepozit;
	}

	public Date getEndDepozit() {
		return endDepozit;
	}

	public void setEndDepozit(Date endDepozit) {
		this.endDepozit = endDepozit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beginDepozit == null) ? 0 : beginDepozit.hashCode());
		result = prime * result + ((endDepozit == null) ? 0 : endDepozit.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DepozitBankAccount other = (DepozitBankAccount) obj;
		if (beginDepozit == null) {
			if (other.beginDepozit != null) {
				return false;
			}
		} else if (!beginDepozit.equals(other.beginDepozit)) {
			return false;
		}
		if (endDepozit == null) {
			if (other.endDepozit != null) {
				return false;
			}
		} else if (!endDepozit.equals(other.endDepozit)) {
			return false;
		}
		if (percent == null) {
			if (other.percent != null) {
				return false;
			}
		} else if (!percent.equals(other.percent)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DepozitBankAccount [idCustomer=" + super.getIdCustomer() + ", status=" + super.getStatus() +" accNum =" + accNum + ", balance=" + balance + " percent=" + percent + ", beginDepozit=" + beginDepozit + ", endDepozit="
				+ endDepozit + "]";
	}

	
	
}
