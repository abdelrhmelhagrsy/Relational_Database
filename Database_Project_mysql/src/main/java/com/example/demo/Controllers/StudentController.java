package com.example.demo.Controllers;

import java.lang.reflect.Array;
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

@RestController
@RequestMapping(path = "student")
public class StudentController {
	private final StudentRepository studentRepository;
	private final  CourseRepository courseRepository;

	@Autowired
	public StudentController(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
    
	@PostMapping(path = "addcourse")
	public void addStudenttoCourse(@RequestParam int courseid,@RequestParam int studentid )
	{
		Optional<Course> _course = courseRepository.findById(courseid);
		Optional<Student> _student = studentRepository.findById(studentid);
		if(_course.isPresent()&&_student.isPresent())
		{
			Course course = _course.get();
			Student student = _student.get();		
			course.setStudents(student);
			courseRepository.save(course);
		}
	}
	@GetMapping(path = "get")
	public Optional<Student> getStudentbyid(@RequestParam int id)
	{
		try {
			return studentRepository.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping(path = "add")
	public void addStudent(@RequestBody Student student)
	{
		try {
			
			 studentRepository.save(student);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	@DeleteMapping(path = "delete")
	public void deleteStudent(@RequestParam int id)
	{
		try {
			if(studentRepository.existsById(id))
			{
				studentRepository.deleteById(id);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping(path = "update")
	public void update_student(@RequestParam int id,@RequestBody Student student)
	{
		try {
			Optional<Student> _student = studentRepository.findById(id); 
			if(_student.isPresent())
			{
				Student student2 = _student.get();
				student2.setFirstname(student.getFirstname());
				student2.setLastname(student.getLastname());
				studentRepository.save(student2);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
