package com.epam.trapeznikau.bean;

public class BankAccount extends Account {
	
	private Integer idCustomer;
	private Boolean status;
	
	public BankAccount(){
		super();
	}
	
	public BankAccount(String accNum, Long balance, Integer idCustomer, Boolean status){
		super(accNum, balance);
		this.idCustomer = idCustomer;
		this.status = status;
	}	
	
	public  void setAccNum(String accNum){
		this.accNum = accNum;		
	}
	
	public  void setBalance(Long balance){
		this.balance = balance;		
	}
	
	public String getAccNum(){
		return accNum;		
	}
	
	public Long getBalance(){
		return  balance;		
	}

	public void setIdCustomer(Integer idCustomer){
		this.idCustomer=idCustomer;
	}	

	public void setStatus(Boolean status){
		this.status=status;
	}
	
	public Integer getIdCustomer(){
		return idCustomer;
	}
	
	public Boolean getStatus(){
		return status;
	}		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idCustomer == null) ? 0 : idCustomer.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (idCustomer == null) {
			if (other.idCustomer != null) {
				return false;
			}
		} else if (!idCustomer.equals(other.idCustomer)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [idCustomer=" + idCustomer + ", status=" + status +" accNum =" + accNum + ", balance=" + balance + "]";
	}	
		
}
