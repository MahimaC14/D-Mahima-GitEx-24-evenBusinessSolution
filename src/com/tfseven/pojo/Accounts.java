package com.tfseven.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Accounts {

	private Integer AccID;
	@NotNull
	private double Amount;
	@NotNull
	private String bankName;
	@NotNull
	private String type;
	private AddEmployee emp;
	
	public Accounts(){}
	
	public Accounts(Integer AccID, double amount, String bankName, String type) {
		super();
		this.AccID = AccID;
		Amount = amount;
		this.bankName = bankName;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAccID() {
		return AccID;
	}

	public void setAccID(Integer AccID) {
		this.AccID = AccID;
	}

	@Column(columnDefinition="double(8,1)")
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}
	@Column(length=20)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name="AccountType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@OneToOne
	@JoinColumn(name="Employee_id")
	public AddEmployee getEmp() {
		return emp;
	}

	public void setEmp(AddEmployee emp) {
		this.emp = emp;
	}

	
	@Override
	public String toString() {
		return "Accounts [sourceAccID=" + AccID + ", Amtount=" + Amount + ", bankName=" + bankName
				+ ", type=" + type + "]";
	}
	
	
}
