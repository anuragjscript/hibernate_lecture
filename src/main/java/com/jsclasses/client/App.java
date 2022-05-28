package com.jsclasses.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.jsclasses.model.StudentAddress;
import com.jsclasses.model.Teacher;
import com.jsclasses.model.TeacherAddress;
import com.jsclasses.model.Course;
import com.jsclasses.model.Student;
import com.jsclasses.service.CourseCRUD;
import com.jsclasses.service.ReviewCRUD;
import com.jsclasses.service.StudentAddressCRUD;
import com.jsclasses.service.StudentCRUD;
import com.jsclasses.service.TeacherAddressCRUD;
import com.jsclasses.service.TeacherCRUD;

/**
 * Hello world!
 *
 */
public class App {
	
	StudentCRUD studentService = new StudentCRUD();
	StudentAddressCRUD addressService = new StudentAddressCRUD();
	TeacherCRUD teacherService = new TeacherCRUD();
	TeacherAddressCRUD teacherAddressService = new TeacherAddressCRUD();
	CourseCRUD courseService = new CourseCRUD();
	ReviewCRUD reviewService = new ReviewCRUD();
	
    public static void main( String[] args ) {
        App action = new App();
        
        action.insertStudent();
        
        action.showAllStudents();
        
        //action.showAddressById(2);
        
        //action.insertTeacher();
        
        //action.showTeacherById(2);
        
        //action.insertCourse();
        
        //action.showAllTeachers();
        
        //action.showCourse(2);
        
    }
    
    /**
     * Student related actions
     * =====================================================================
     * @throws IOException 
     */
    
    public void insertStudent() {
		
		Student student = new Student();
		StudentAddress studentAddress = new StudentAddress();
		
		// set data values
		student.setF_name("Anurag");
		student.setL_name("Jaisingh");
		student.setEmail("anukhg@gmail.com");
		student.setAdmissionDate(new Date());
		
		// read image from location and save in student object
		try {
			FileInputStream fis = null;
			fis = new FileInputStream("src/main/java/images/abcd.jpg");
			byte[] data = new byte[fis.available()];
			fis.read(data);
			student.setImage(data);
			fis.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// set values to student address object
		studentAddress.setAddline1("SDO Road");
		studentAddress.setAddline2("");
		studentAddress.setCity("Khagaria");
		studentAddress.setState("Bihar");
		studentAddress.setCountry("India");

		// set address details to student
		student.setStudentAddress(studentAddress);
		
		// insert all data into student table
		studentService.insertStudentRecord(student);
		
	}
	
	public void showAllStudents() {
		
		List<Student> students = studentService.fetchAllStudents();

		for(Student student : students) {
			System.out.println("-----------------------------------");
			System.out.println( student.toString() );
		}
		
	}
	
	public void showStudentById(int studentId) {
		Student student = studentService.fetchStudentById(studentId);
		if( student == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( student.toString() );
			System.out.println( student.getStudentAddress().toString() );
		}
	}
	
	public void deleteStudentById(int studentId) {
		if ( studentService.deleteStudentById(studentId) ) {
			System.out.println("Deleted");
		} else {
			System.out.println("Nothing to delete");
		}
		
	}
	
	/**
	 * Student Address related actions
	 * =======================================================================
	 */
	
	public void showAddressById(int addressId) {
		StudentAddress address = addressService.fetchAddressById(addressId);
		if( address == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( address.toString() );
			System.out.println( "Associated : " + address.getStudent().toString() );			
		}
	}
	
	public void deleteAddressById(int addressId) {
		if ( addressService.deleteAddressById(addressId) ) {
			System.out.println("Deleted");
		} else {
			System.out.println("Nothing to delete");
		}
		
	}
	
	/**
     * Teacher related actions
     * =====================================================================
     */
    
    public void insertTeacher() {
		
    	Teacher teacher1 = new Teacher("Anurag Jaisingh", "anukhg@gmail.com");
    	Teacher teacher2 = new Teacher("Anupama Tomar", "anukgg@gmail.com");
    	Teacher teacher3 = new Teacher("Animesh Singh", "annie@gmail.com");
		
    	TeacherAddress teacher1Address = new TeacherAddress("SDO Road", "", "Khagaria", "Bihar");
    	TeacherAddress teacher2Address = new TeacherAddress("Saltlake", "Sector 2", "Kolkata", "West Bengal");
    	TeacherAddress teacher3Address = new TeacherAddress("Mayur Vihar", "Phase 2", "Noida", "NCR");
		
    	teacher1.setTeacherAddress(teacher1Address);
    	teacher2.setTeacherAddress(teacher2Address);
    	teacher3.setTeacherAddress(teacher3Address);
		
		teacherService.insertTeacherRecord(teacher1);
		teacherService.insertTeacherRecord(teacher2);
		teacherService.insertTeacherRecord(teacher3);
		
	}
	
	public void showAllTeachers() {
		
		List<Teacher> teachers = teacherService.fetchAllTeachers();

		for(Teacher teacher : teachers) {
			System.out.println("-----------------------------------");
			System.out.println( teacher.toString() );
			System.out.println( "Associated : " + teacher.getTeacherAddress().toString() );
		}
		
	}
	
	public void showTeacherById(int teacherId) {
		Teacher teacher = teacherService.fetchTeacherById(teacherId);
		if( teacher == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( teacher.toString() );
			System.out.println( teacher.getTeacherAddress().toString() );
		}
	}
	
	public void deleteTeacherById(int teacherId) {
		if ( teacherService.deleteTeacherById(teacherId) ) {
			System.out.println("Deleted");
		} else {
			System.out.println("Nothing to delete");
		}
		
	}
	
	/**
	 * Teacher Address related actions
	 * =======================================================================
	 */
	
	public void showTeacherAddressById(int addressId) {
		TeacherAddress address = teacherAddressService.fetchAddressById(addressId);
		if( address == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( address.toString() );
			System.out.println( "Associated : " + address.getTeacher().toString() );			
		}
	}
	
	public void deleteTeacherAddressById(int addressId) {
		if ( teacherAddressService.deleteAddressById(addressId) ) {
			System.out.println("Deleted");
		} else {
			System.out.println("Nothing to delete");
		}
		
	}
	
	/**
	 * Insert Course
	 * ================================================================
	 */
	
	public void insertCourse() {
        
        Course course = new Course("C++", 5);
        courseService.insertCourseRecord(course, 1);
        
	}
	
	public void showCourse(int teacherId) {
		List<Course> courses = courseService.getCourseTeacher(teacherId);
		for(Course course : courses) {
			System.out.println("-----------------------------------");
			System.out.println( course.toString() );
			System.out.println( course.getTeacher().toString() );
		}
	}
	
}
