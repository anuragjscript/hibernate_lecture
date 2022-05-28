package com.jsclasses.client;

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
        
        //action.insertStudent();
        
        //action.showAllStudents();
        
        //action.showAddressById(2);
        
        //action.insertTeacher();
        
        //action.showTeacherById(2);
        
        //action.insertCourse();
        
        action.showAllTeachers();
        
        System.out.println("Done--------------");
        
    }
    
    /**
     * Student related actions
     * =====================================================================
     */
    
    public void insertStudent() {
		
		Student student1 = new Student("Anurag", "Jaisingh", "anukhg@gmail.com");
		Student student2 = new Student("Anupama", "Tomar", "anukgg@gmail.com");
		Student student3 = new Student("Animesh", "Singh", "annie@gmail.com");
		
		StudentAddress student1Address = new StudentAddress("SDO Road", "", "Khagaria", "Bihar", "India");
		StudentAddress student2Address = new StudentAddress("Saltlake", "Sector 2", "Kolkata", "West Bengal", "India");
		StudentAddress student3Address = new StudentAddress("Mayur Vihar", "Phase 2", "Noida", "NCR", "India");
		
		student1.setStudentAddress(student1Address);
		student2.setStudentAddress(student2Address);
		student3.setStudentAddress(student3Address);
		
		studentService.insertStudentRecord(student1);
		studentService.insertStudentRecord(student2);
		studentService.insertStudentRecord(student3);
		
	}
	
	public void showAllStudents() {
		
		List<Student> students = studentService.fetchAllStudents();

		for(Student student : students) {
			System.out.println("-----------------------------------");
			System.out.println( student.toString() );
			System.out.println( "Associated : " + student.getStudentAddress().toString() );
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
        
        Course course = new Course("React JS", 3);
        courseService.insertCourseRecord(course, 2);
        
	}
	
}
