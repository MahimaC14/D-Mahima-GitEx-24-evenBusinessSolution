package com.tfseven.pojo;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Company {
	
	private Integer id;
	@NotEmpty(message="Name must not be blank")
	private String name;
	@NotEmpty(message="Email must not be blank")
	@Email(message="Invalid Email")
	private String email;
	/*@NotEmpty(message="Password must be supplied")
	private String password;
	@NotNull(message="Date must not be blank")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date regDate;*/
	@NotNull(message="Amount must not be blank")
	@Range(min=500,max=5000,message="Invalid Reg Amount")
	private double regAmount;
	public Company() {
		System.out.println("in cust constr");
	}
	public Company(String name, String email /*String password, Date regDate*/) {
		
		this.name = name;
		this.email = email;
		//this.password = password;
		//this.regDate = regDate;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	*/
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" /*+ password + ", regDate=" + regDate + "]"*/;
	}
	
	

}
