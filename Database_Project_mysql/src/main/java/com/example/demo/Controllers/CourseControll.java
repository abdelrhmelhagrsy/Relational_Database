package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Course;
import com.example.demo.Student;
import com.example.demo.Teacher;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(path = "course")
public class CourseControll {
	
	private final CourseRepository courseRepository;
	private final CourseDetailsRepository courseDetailsRepository;
	private final TeacherRepository teacherRepository;
	@Autowired
	public CourseControll(CourseRepository courseRepository, CourseDetailsRepository courseDetailsRepository,TeacherRepository teacherRepository) {
		
		this.courseRepository = courseRepository;
		this.courseDetailsRepository = courseDetailsRepository;
		this.teacherRepository = teacherRepository;
	}
	@GetMapping(path = "getall")
	public List<Course> get_allCourses()
	{
		try {
			
			return courseRepository.findAll();			
		}catch(Exception e) {
			 e.printStackTrace();
			 return null;
		}
	}
	
	// get all students in specific course 
	@GetMapping(path = "getallstudents")
	public List<Student> get_all_students_inCourse(@RequestParam int id)
	{
		try {
		Optional<Course> _course = courseRepository.findById(id);
		if(_course.isPresent())
		{
			return _course.get().getStudents();
		}
		else
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	  
	@PostMapping(path = "add")
	public void add_course(@RequestParam int teacherid,@RequestBody Course course)
	{
		try {
			    Optional<Teacher> teacher = teacherRepository.findById(teacherid);
			  if(teacher.isPresent())
			  {
				  Teacher nteacher = teacher.get();
				  course.setTeacher(nteacher);
				  courseRepository.save(course);
			  }
		}catch (Exception e) {
			
			 e.printStackTrace();
		}
		
	}
	
	@DeleteMapping(path = "delete")
	public void delete_Course(@RequestParam int id)
	{
		try {
			 Optional<Course> teacher_data =  courseRepository.findById(id);
		     if(teacher_data.isPresent()) {
		    	
		    	 courseRepository.deleteById(id);
		    	
		     }
		
		} catch (Exception e) {
			
			 e.printStackTrace();
		}
	}
  
	@PutMapping(path = "update")
	public void uodate_Course(@RequestParam int id,@RequestBody Course course)
	{
		try {
			 Optional<Course> _course = courseRepository.findById(id);
			 if(_course.isPresent())
			 {
				 Course ncourse = _course.get();
				 ncourse.setPrice(course.getPrice());
				 ncourse.setTitle(course.getTitle());
				 courseRepository.save(ncourse);
		     }
		
		} catch (Exception e) {
			
			 e.printStackTrace();		
			 
		}
	}
	
}
