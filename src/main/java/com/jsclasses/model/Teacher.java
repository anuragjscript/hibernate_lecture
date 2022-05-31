package com.jsclasses.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	// setting up mapping between teacher & course
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher",
				cascade = {CascadeType.ALL})
	private List<Course> courses;
	
	@Column(name = "address")
	private Address address;
	
	public Teacher() {

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	//adding a method for uni-directional relationship
	public void add(Course course) {
		if(this.courses==null) {
			this.courses = new ArrayList<Course>();
		}
		this.courses.add(course);
		course.setTeacher(this);
	}
	
	public List<Course> getCourse() {
		return this.courses;
	}
		
}
