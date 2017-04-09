package com.epam.trapeznikau.bean;

import java.util.Date;

public class CreditBankAccount extends BankAccount{
	
	private Float percent;
	private Date beginCredit;
	private Date endCredit;
	
	public CreditBankAccount (){
		super();
	}
	
	public CreditBankAccount (String accNum, Long balance, Integer idCustomer, Boolean status, Float percent, Date beginCredit, Date endCredit){
		super(accNum, balance, idCustomer, status);
		this.percent = percent;
		this.beginCredit = beginCredit;
		this.endCredit = endCredit;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public Date getBeginCredit() {
		return beginCredit;
	}

	public void setBeginCredit(Date beginCredit) {
		this.beginCredit = beginCredit;
	}

	public Date getEndCredit() {
		return endCredit;
	}

	public void setEndCredit(Date endCredit) {
		this.endCredit = endCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beginCredit == null) ? 0 : beginCredit.hashCode());
		result = prime * result + ((endCredit == null) ? 0 : endCredit.hashCode());
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
		CreditBankAccount other = (CreditBankAccount) obj;
		if (beginCredit == null) {
			if (other.beginCredit != null) {
				return false;
			}
		} else if (!beginCredit.equals(other.beginCredit)) {
			return false;
		}
		if (endCredit == null) {
			if (other.endCredit != null) {
				return false;
			}
		} else if (!endCredit.equals(other.endCredit)) {
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
		return "CreditBankAccount [idCustomer=" + super.getIdCustomer() + ", status=" + super.getStatus() +" accNum =" + accNum + ", balance=" + balance + " percent=" + percent + ", beginCredit=" + beginCredit + ", endCredit="
				+ endCredit + "]";
	}
	
}
