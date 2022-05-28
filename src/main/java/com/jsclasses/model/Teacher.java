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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	// setting up mapping between teacher & teacher address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_address_id")
	private TeacherAddress teacherAddress;
	
	// setting up mapping between teacher & course
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher",
				cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Teacher() {

	}

	public Teacher(String name, String email) {
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	public TeacherAddress getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(TeacherAddress teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	//adding a method for uni-directional relationship
	public void add(Course course) {
		if(this.courses==null) {
			this.courses = new ArrayList<Course>();
		}
		this.courses.add(course);
		course.setTeacher(this);
	}
	
	public Course getCourse() {
		return this.getCourse();
	}
		
}
