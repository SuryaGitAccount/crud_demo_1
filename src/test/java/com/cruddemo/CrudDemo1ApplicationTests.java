package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entities.Student;
import com.cruddemo.repositories.StudentRepository;

@SpringBootTest
class CrudDemo1ApplicationTests {
	//save()
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	@Test
	void saveOneStudentInformation() {
		Student s= new Student();
		s.setName("rahul");
		s.setCourse("tester");
		s.setFee(5000);
		studentRepo.save(s);
	}
	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(7L);
	}
	@Test
	void getOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		System.out.println(student.getName());
	}
	@Test
	void updateOneStudentInformation() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		student.setName("pari");
		studentRepo.save(student);
	}
	@Test
	void getAllStudents() {
		Iterable<Student> student = studentRepo.findAll();
		System.out.println(student);
		for (Student students : student) {
			System.out.println(students.getId());
			System.out.println(students.getName());
			System.out.println(students.getCourse());
			System.out.println(students.getFee());
		}
	}

}
