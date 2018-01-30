package com.tfseven.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
public class SalaryInfo {

	private Integer id;
	@NotNull
	private int empID;
	@NotNull
	private double basicSal;
	@NotNull
	private double DA;
	@NotNull
	private double travelAllowance;
	@NotNull
	private double medicalAllowance;
	@NotNull
	private double totalSalary;
	
	//private Employee emp;
	
	public SalaryInfo(Integer id, int empID, double basicSal, double dA, double travelAllowance,
			double medicalAllowance, double totalSalary) {
		super();
		this.id = id;
		this.empID = empID;
		this.basicSal = basicSal;
		this.DA = dA;
		this.travelAllowance = travelAllowance;
		this.medicalAllowance = medicalAllowance;
		this.totalSalary = totalSalary;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Column(name="EmployeeID")
//	public int getEmpID() {
//		return empID;
//	}
//
//	public void setEmpID(int empID) {
//		this.empID = emp.getID();
//	}

	@Column(columnDefinition="double(6,1)")
	public double getBasicSal() {
		return basicSal;
	}

	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}

	@Column(columnDefinition="double(6,1)")
	public double getDA() {
		return DA;
	}

	public void setDA(double dA) {
		DA = dA;
	}

	@Column(columnDefinition="double(6,1)")
	public double getTravelAllowance() {
		return travelAllowance;
	}

	public void setTravelAllowance(double travelAllowance) {
		this.travelAllowance = travelAllowance;
	}

	@Column(columnDefinition="double(6,1)")
	public double getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(double medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	
	@Column(columnDefinition="double(6,1)",name="Total")
	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "SalaryInfo [id=" + id + ", basicSal=" + basicSal + ", DA=" + DA + ", travelAllowance=" + travelAllowance
				+ ", medicalAllowance=" + medicalAllowance + "]";
	}

	
	
}
