package com.example.demo.Controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Integer>{
	
	

}
