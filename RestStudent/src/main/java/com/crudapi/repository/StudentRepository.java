package com.crudapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudapi.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	

}
