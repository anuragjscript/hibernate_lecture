package com.jsclasses.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_table")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;
	
	@Column(name = "staff_address")
	private Address staff_address;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Address getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(Address staff_address) {
		this.staff_address = staff_address;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", email=" + email + ", dateOfJoining=" + dateOfJoining
				+ ", staff_address=" + staff_address + "]";
	}
	
	

}
