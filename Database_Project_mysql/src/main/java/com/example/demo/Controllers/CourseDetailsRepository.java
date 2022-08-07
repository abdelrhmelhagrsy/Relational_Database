package com.example.demo.Controllers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CourseDetails;

@Repository
public interface CourseDetailsRepository extends CrudRepository<CourseDetails, Integer> {

	//List<CourseDetails> findAll();
	//CourseDetails findbyId(int id);
	
	 @Override
	  List<CourseDetails> findAll();
	 
}
