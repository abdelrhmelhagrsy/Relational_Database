package com.example.demo.Controllers;

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

import com.example.demo.Teacher;

@RestController
@RequestMapping(path = "teacher")
public class TeacherControll {
	
	private final TeacherRepository teacher_repository;
	private final CourseRepository  courseRepository;

	@Autowired
	public TeacherControll(TeacherRepository repository,CourseRepository  courseRepository) {
		
		this.teacher_repository = repository;
		this.courseRepository=courseRepository;
	}
	
	
	@GetMapping(path = "getbyid")
    public Teacher get_teacher(@RequestParam int id)
    {
		if(teacher_repository.existsById(id))
		{
			return teacher_repository.findById(id).get();
		}
		else
			return null;
    }
	@PostMapping(path = "add")
	public void add_teacher(@RequestBody Teacher teacher)
	{
		teacher_repository.save(teacher);
	}
	
	@PutMapping(path = "update")
	public void uodate_teacher(@RequestParam int id,@RequestBody Teacher teacher)
	{
		try {
			 Optional<Teacher> teacher_data =  teacher_repository.findById(id);
		     if(teacher_data.isPresent()) {
		    	 Teacher nteacher = teacher_data.get();
		    	 nteacher.setAge(teacher.getAge());
		    	 nteacher.setName(teacher.getName());
		    	 teacher_repository.save(nteacher);
		     }
		
		} catch (Exception e) {
			
			
		}
	}
	@DeleteMapping(path = "delete")
	public void delete_teacher(@RequestParam int id)
	{
		try {
			 Optional<Teacher> teacher_data =  teacher_repository.findById(id);
		     if(teacher_data.isPresent()) {
		    	
		    	
		    	 teacher_repository.deleteById(id);
		    	 
		     }
		
		} catch (Exception e) {
			
			
		}
	}

}
