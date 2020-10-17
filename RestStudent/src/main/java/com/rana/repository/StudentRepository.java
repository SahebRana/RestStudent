package com.rana.repository;

import org.springframework.data.repository.CrudRepository;

import com.rana.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	

}
