package com.crudapi.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapi.model.Student;
import com.crudapi.repository.StudentRepository;

@Service
public class StudentListOperation implements StudentList{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public 	Optional<Student> getStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findById(id);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> st = new ArrayList<>();
		studentRepository.findAll().forEach(st::add);
		return st;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

}
