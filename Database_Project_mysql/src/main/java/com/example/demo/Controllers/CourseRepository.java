package com.example.demo.Controllers;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Course;
import com.example.demo.CourseDetails;
import com.example.demo.Teacher;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

	 @Modifying
	 @Query("delete from Course u where u.teacher = ?1")
	void deleteByTeacherid(Teacher teacher);
	
	 @Override
	  List<Course> findAll();
	 
}
