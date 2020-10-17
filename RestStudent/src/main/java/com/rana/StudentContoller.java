package com.rana;

import java.util.List;
import java.util.Optional;

import com.rana.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rana.list.StudentList;

@RestController
public class StudentContoller {
	@GetMapping()
	public String test() {
		return "<h1>Simple Spring Boot CRUD project</h1>";
	}
	
	@Autowired
	StudentList stlist;
	
	@GetMapping("/student/all")
	List<Student> getAllStudent(){
		return stlist.getAllStudent();
	}
	
	@PostMapping(value ="/student/add")
	public void addStudent(@RequestBody Student student) {
		stlist.addStudent(student);
	}
	
	@PutMapping("/student/update")
	public void updateStudent(@RequestBody Student student) {
		stlist.updateStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return stlist.getStudent(id);
	}
	
	@DeleteMapping("/student/delete/{id}")
	void deleteStudent(@PathVariable int id) {
		stlist.deleteStudent(id);
	}
	
	
	
	
}
