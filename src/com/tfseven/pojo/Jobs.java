package com.tfseven.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Jobs 
{
	int job_id;
	@NotNull
	String job_title;
	@NotNull
	double min_salary;
	@NotNull
	double max_salary;
	private Employee emp;

	public Jobs(){}

	public Jobs(int job_id, String job_title, double min_salary, double max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	@Column(length=20)
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
	@Column(columnDefinition="double(6,1)",name="min_salary")
	public double getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(double min_salary) {
		this.min_salary = min_salary;
	}
	
	@Column(length=20)
	public double getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(double max_salary) {
		this.max_salary = max_salary;
	}
	
	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}
	
	

}
