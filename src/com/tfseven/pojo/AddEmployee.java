package com.tfseven.pojo;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="AddEmployees")
public class AddEmployee

{
	Integer employee_id;
	@NotNull
	String first_name;
	@NotNull
	String last_name;
	@NotNull
	String email;
	/*@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")*/
	/*@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")*/
	@NotNull
	long phone_number;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	Date hire_date;
	@NotNull
	double salary;
	
	private Accounts acc;
	private Jobs job;
	private Locations loc;
	private Departments drpt;

	public AddEmployee(int employee_id, String first_name, String last_name, String email, long phone_number,
			Date hire_date, float salary, int department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
	}
	
	public AddEmployee(){}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=20)
	public Integer getEmployee_id() {
		return employee_id;
	}
	
	
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	@Column(length=20)
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(length=20)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(length=15,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length=10)
	public long getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	
	@Column(columnDefinition="double(6,1)")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@OneToOne(mappedBy="emp",cascade=CascadeType.ALL)
	public Accounts getAcc() {
		return acc;
	}

	public void setAcc(Accounts acc) {
		this.acc = acc;
	}

	public void addAccount(Accounts acc)
	{
		this.acc=acc;
		acc.setEmp(this);
	}
	

	@OneToOne
	@JoinColumn(name = "DepartmentId")
	public Departments getDrpt() {
		return drpt;
	}

	public void setDrpt(Departments drpt) {
		this.drpt = drpt;
	}

	@OneToOne
	@JoinColumn(name = "JobId")
	public Jobs getJob() {
		return job;
	}


	public void setJob(Jobs job) {
		this.job = job;
	}

	@OneToOne
	@JoinColumn(name = "locationId")
	public Locations getLoc() {
		return loc;
	}


	public void setLoc(Locations loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", salary=" + salary + "]";
	}
	
	

}
