package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CourseDetails;
import com.example.demo.Teacher;

@RestController
@RequestMapping(path = "course_details")
public class CourseDetailsControll {
      private final CourseDetailsRepository detailsRepository;
      private final CourseRepository courseRepository;
      private final TeacherRepository Teacher_repository;
      @Autowired
	public CourseDetailsControll(CourseDetailsRepository detailsRepository, CourseRepository courseRepository,TeacherRepository Teacher_repository) {
		super();
		this.detailsRepository = detailsRepository;
		this.courseRepository = courseRepository;
		this.Teacher_repository = Teacher_repository;
	}
      
      @GetMapping(path = "getall")
      public List<CourseDetails> get_all_coursesDetails()
      {
    	  try {
    	  return  detailsRepository.findAll();
    	  }catch (Exception e) {
    		  e.printStackTrace();
    		  return null;
		}
      }
      @GetMapping(path = "getbyid")
      public Optional<CourseDetails> get_courseDetails(@RequestParam int id)
      {
    	  try {
    	  if(detailsRepository.existsById(id))
  		{
  			return detailsRepository.findById(id);
  		}
    	  
  		else
  			return null;
    	  
    	  }catch (Exception e) {
    		  e.printStackTrace();
    		  return null;
		}
      }
      
      @PostMapping(path = "add")
      public void add_courseContent( @RequestBody CourseDetails courseDetails)
      {
    	  try {
    		
    		  
    		  detailsRepository.save(courseDetails);
    		  
    	  }catch (Exception e) {
  			
    		  e.printStackTrace();
  		}
      }
      
      
      
      
      @PutMapping(path = "update")
      public void update_CourseDetails(@RequestParam int id,@RequestBody CourseDetails courseDetails)
      {
    	  try {
    	  if(detailsRepository.existsById(id))
    	  {
    		  CourseDetails courseDetails2 = new CourseDetails();
    		  courseDetails2.setCourseDetailsID(id);
    		  courseDetails2.setStart_date(courseDetails.getStart_date());
    		  courseDetails2.setEnd_date(courseDetails.getEnd_date());
    		  courseDetails2.setContent_url(courseDetails.getContent_url());
    		  detailsRepository.deleteById(id);
    		  detailsRepository.save(courseDetails2);
    	  }
    	  }catch (Exception e) {
    		  e.printStackTrace();
		}
      }
    	  
      
      @DeleteMapping(path = "delete")
      public void delete_Course_Details(@RequestParam int id)
      {
    	  try {
    	  if(detailsRepository.existsById(id))
    	  {
    		  detailsRepository.deleteById(id);
    	  }
    	  }catch (Exception e) {
    		  e.printStackTrace();
		}
      }
      
}
