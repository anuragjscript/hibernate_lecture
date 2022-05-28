package com.jsclasses.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "student_address")
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "addline1", nullable = false)
	private String addline1;
	
	@Column(name = "addline2")
	private String addline2;
	
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	
	@Transient
	private String country;
	
	@OneToOne(mappedBy = "studentAddress",cascade = CascadeType.ALL)
	private Student student;

	public StudentAddress() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddline1() {
		return addline1;
	}

	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}

	public String getAddline2() {
		return addline2;
	}

	public void setAddline2(String addline2) {
		this.addline2 = addline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addline1=" + addline1 + ", addline2=" + addline2 + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
	
	public Student getStudent() {
		return student;
	}

}
