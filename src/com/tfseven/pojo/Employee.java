package com.tfseven.pojo;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {

	private Integer id;
	@NotEmpty(message="Name can't be blank")
	@Length(min=3,max=20,message="Invalid Name length")
	private String name;
	@NotNull
	@Email
	private String email;
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or Invalid Password")
	private String password;
	@Transient
	private String cPassword;
	@Transient
	private String nPassword;
	@NotNull
	private String role;
	@Transient
	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}


	public String getnPassword() {
		return nPassword;
	}

	public void setnPassword(String oPassword) {
		this.nPassword = oPassword;
	}


	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date regDate;
	private Address addr;
	
	public Employee(){}
	
	public Employee(Integer id, String name, String email, String password, String role, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regDate = regDate;
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

	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length=20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public void addAddress(Address address)
	{
		this.addr=address;
		address.setUser(this);
	}
	
	@Override
	public String toString() {
		return "Registration [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role
				+ ", regDate=" + regDate + "]";
	}	
}
