package client;

import java.util.List;

import model.Address;
import model.Student;
import service.StudentCRUD;

public class StudentCRUDClient {
	
	StudentCRUD crudService = new StudentCRUD();

	public static void main(String[] args) {
		
		StudentCRUDClient action = new StudentCRUDClient();
		
		//action.insertStudent();
		
		//action.showStudentById(1);
		
		action.deleteStudentById(2);
		
		action.showAllStudents();
		
	}
	
	public void insertStudent() {
		
		Student student1 = new Student("Anurag", "Jaisingh", "anukhg@gmail.com");
		Student student2 = new Student("Anupama", "Tomar", "anukgg@gmail.com");
		
		Address student1Address = new Address("SDO Road", "", "Khagaria", "Bihar", "India");
		Address student2Address = new Address("SDO Road", "", "Khagaria", "Bihar", "India");
		
		student1.setStudentAddress(student1Address);
		student2.setStudentAddress(student2Address);
		
		crudService.insertStudentRecord(student1);
		crudService.insertStudentRecord(student2);
		
	}
	
	public void showAllStudents() {
		
		List<Student> students = crudService.fetchAllStudents();

		for(Student student : students) {
			System.out.println("-----------------------------------");
			System.out.println( student.toString() );
			System.out.println( student.getStudentAddress().toString() );
		}
		
	}
	
	public void showStudentById(int studentId) {
		Student student = crudService.fetchStudentById(studentId);
		System.out.println( student.toString() );
	}
	
	public void deleteStudentById(int studentId) {
		crudService.deleteStudentById(studentId);
		System.out.println("Deleted");
	}

}
