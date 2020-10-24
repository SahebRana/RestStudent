package com.rana;


import java.util.List;
import java.util.Optional;

import com.rana.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rana.list.StudentList;

@RestController
public class StudentContoller {
	@Autowired
	StudentList stlist;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/student/")
	List<Student> getAllStudent(){
            System.err.println("Hello world!");
		return stlist.getAllStudent();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value ="/student/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student) {
		stlist.addStudent(student);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/student/")
	public void updateStudent(@RequestBody Student student) {
		stlist.updateStudent(student);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return stlist.getStudent(id);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping("/student/{id}")
	void deleteStudent(@PathVariable int id) {
		stlist.deleteStudent(id);
	}
			
}
