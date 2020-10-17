package com.rana.list;

import java.util.List;
import java.util.Optional;

import com.rana.model.Student;


public interface StudentList {
	
	Optional<Student> getStudent(int id);
	List<Student> getAllStudent();
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int id);

}
