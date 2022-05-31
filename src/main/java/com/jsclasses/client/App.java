package com.jsclasses.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.jsclasses.model.Teacher;
import com.jsclasses.model.Address;
import com.jsclasses.model.Course;
import com.jsclasses.model.Department;
import com.jsclasses.model.Salary;
import com.jsclasses.model.Staff;
import com.jsclasses.model.Student;
import com.jsclasses.service.CourseCRUD;
import com.jsclasses.service.ReviewCRUD;
import com.jsclasses.service.SalaryCRUD;
import com.jsclasses.service.StaffCRUD;
import com.jsclasses.service.StudentCRUD;
import com.jsclasses.service.TeacherCRUD;

/**
 * Hello world!
 *
 */
public class App {
	
	StudentCRUD studentService = new StudentCRUD();
	TeacherCRUD teacherService = new TeacherCRUD();
	CourseCRUD courseService = new CourseCRUD();
	ReviewCRUD reviewService = new ReviewCRUD();
	StaffCRUD staffService = new StaffCRUD();
	SalaryCRUD salaryService = new SalaryCRUD();
	
	
    public static void main( String[] args ) {
        App action = new App();
        
        //action.insertStudent();
        
        //action.showAllStudents();
        
        //action.showStudentById(1);
        
        //action.showAddressById(2);
        
        //action.insertTeacher();
        
        //action.showTeacherById(1);
        
        //action.insertCourse();
        
        //action.showAllTeachers();
        
        //action.showAllTeachersWithCourses();
        
        action.showTeacherByIdWithCourses(1);
        
        //action.showCourse(1);
        
        //action.insertStaff();
        
        //action.showStaffBySalaryId(1);
        
        //action.mapCourseToStudent();
        
    }
    
    /**
     * Student - Course Mapping
     * 
     */
    
    public void mapCourseToStudent() {
    	
    	studentService.updateStudentRecord(1, 1);
    	
    	studentService.updateStudentRecord(6, 1);
    	studentService.updateStudentRecord(6, 2);
    	
    }
    
    /**
     * Student related actions
     * =====================================================================
     * @throws IOException 
     */
    
    public void insertStudent() {
		
		Student student = new Student();
		
		// set data values
		student.setF_name("Anupama");
		student.setL_name("Tomar");
		student.setEmail("anukgg@gmail.com");
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
		Address address = new Address();
		address.setAddressLine1("Sector 2");
		address.setAddressLine2("");
		address.setCity("Bidhannagr");
		address.setState("West Bengal");
		address.setCountry("India");
		student.setAddress(address);
		
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
     * Teacher related actions
     * =====================================================================
     */
    
    public void insertTeacher() {
		
    	Teacher teacher = new Teacher();
    	
    	teacher.setName("Ramesh Chauhan");
    	teacher.setEmail("ramesh@gmail.com");
    	
    	Address address = new Address();
    	address.setAddressLine1("Bailiey Road");
    	address.setAddressLine1("Near Secretariat");
    	address.setCity("Patna");
    	address.setState("Bihar");
    	address.setCountry("India");
    	
    	teacher.setAddress(address);
    	
    	Course course1 = new Course();
    	course1.setName("Core Java");
    	course1.setDuration(6);
    	course1.setTeacher(teacher);
    	
    	teacher.add(course1);
    	
		teacherService.insertTeacherRecord(teacher);
		
	}
	
	public void showAllTeachers() {
		
		List<Teacher> teachers = teacherService.fetchAllTeachers();

		for(Teacher teacher : teachers) {
			System.out.println("-----------------------------------");
			System.out.println( teacher.getName() );
		}
		
	}
	
	public void showAllTeachersWithCourses() {
		
		List<Teacher> teachers = teacherService.fetchAllTeachersWithCourses();

		for(Teacher teacher : teachers) {
			System.out.println("-----------------------------------");
			System.out.println( teacher.getName() );
			System.out.println( teacher.getCourse() );
		}
		
	}
	
	public void showTeacherById(int teacherId) {
		Teacher teacher = teacherService.fetchTeacherById(teacherId);
		if( teacher == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( teacher.getName() + " " + teacher.getEmail() );
		}
	}
	
	public void showTeacherByIdWithCourses(int teacherId) {
		System.out.println( teacherService.fetchAllCoursesByTeacherId(teacherId) );
	}
	
	public void deleteTeacherById(int teacherId) {
		if ( teacherService.deleteTeacherById(teacherId) ) {
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
        
        Course course = new Course("Python", 12);
        courseService.insertCourseRecord(course, 1);
        
        Course course1 = new Course("Laravel", 10);
        courseService.insertCourseRecord(course1, 0);
        
	}
	
	public void showCourse(int teacherId) {
		List<Course> courses = courseService.getCourseTeacher(teacherId);
		for(Course course : courses) {
			System.out.println("-----------------------------------");
			System.out.println( course.toString() );
			System.out.println( "Taught BY : " + course.getTeacher().getName() );
		}
	}
	
	public void showCourse() {
		List<Course> courses = courseService.getCourseTeacher();
		for(Course course : courses) {
			System.out.println("-----------------------------------");
			System.out.println( course.toString() );
			try {
				System.out.println( "Taught BY : " + course.getTeacher().getName() );
			} catch(NullPointerException e) {
				System.out.println("Not assigned to any teacher");
			}
		}
	}
	
	/**
	 * Insert Saff
	 * ====================================================================
	 */
	
	public void insertStaff() {
		
		Staff staff = new Staff();
		staff.setName("Animesh Kashyap");
		staff.setEmail("annie@gmail.com");
		staff.setDateOfJoining( new Date() );
		
		Address address = new Address();
		address.setAddressLine1("Vijaynagar");
		address.setAddressLine2("");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		
		staff.setAddress(address);
		
		Salary salary = new Salary();
		salary.setDept( Department.HR );
		salary.setScale(2);
		salary.setBasic(35000);
		salary.setHra(7);
		salary.setDa(4);
		salary.setTa(5);
		salary.setStaff(staff);
		
		staff.setSalary(salary);
		
		staffService.insertTeacherRecord(staff);
	}
	
	/**
	 * Salary CRUD
	 * ==========================================================
	 */
	
	public void showStaffBySalaryId(int salaryId) {
		String name = salaryService.getStaffBySalary(salaryId);
        System.out.println(name);
	}
	
}
