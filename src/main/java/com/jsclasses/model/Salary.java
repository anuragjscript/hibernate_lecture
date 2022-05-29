package com.jsclasses.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int scale;
	private Department dept;
	private double basic;
	private float hra;
	private float da;
	private float ta;
	
	@OneToOne(mappedBy = "salary", cascade = CascadeType.ALL)
	private Staff staff;
	
	public Salary() {
		
	}

	public int getId() {
		return id;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	public float getDa() {
		return da;
	}

	public void setDa(float da) {
		this.da = da;
	}

	public float getTa() {
		return ta;
	}

	public void setTa(float ta) {
		this.ta = ta;
	}

	@Override
	public String toString() {
		String result = "Salary\n";
		result += "[\n";
		result += "	id=" + id + ",\n";
		result += "	scale=" + scale + ",\n";
		result += "	dept=" + dept + ",\n";
		result += "	basic=" + basic + ",\n";
		result += "	hra=" + hra + ",\n";
		result += "	da=" + da + ",\n";
		result += "	ta=" + ta + "\n";
		result += "]";
		result += "Staff name = " + getStaff();
		return result;
	}
	
}