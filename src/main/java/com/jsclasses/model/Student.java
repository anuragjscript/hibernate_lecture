package com.jsclasses.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "f_name", nullable = false)
	private String f_name;
	
	@Column(name = "l_name")
	private String l_name;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Lob
	@Column(name = "profile_picture")
	private byte[] image;
	
	@Column(name = "addmission_date")
	@Temporal(TemporalType.DATE)
	private Date admissionDate;
	
	@Column(name = "address")
	private Address address;
	
	@ManyToMany
	(
		mappedBy = "students",
		cascade = CascadeType.ALL
	)
	private List<Course> courses;
	
	public Student() {

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

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + ", admissionDate=" + admissionDate + ", address=" + address + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		if(this.courses == null) {
			this.courses = new ArrayList<Course>();
		}
		this.courses.add(course);
	}

}
