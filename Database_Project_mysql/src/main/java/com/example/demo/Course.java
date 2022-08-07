package com.example.demo;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;





@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseID;
	private String title;
	private Integer price;
	
	
	//onr to one relation 
	
	@OneToOne(mappedBy = "course")
	private CourseDetails courseDetails;
	
	// many to one relation
	@ManyToOne(
            cascade = CascadeType.ALL ,fetch =  FetchType.EAGER
    )
    @JoinColumn(
            name = "fk_teacher_id"
           
    )
    private Teacher teacher;
	
	
	 // Many-to-many relationship with Student
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "courseID",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentID"
            )
    )
    
    private List<Student> students;
	
	
	
	
	
	
	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(Student students) {
		this.students.add(students);
	}


	public Course() {
		super();
	}


	public int getCourseID() {
		return courseID;
	}


	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public CourseDetails getCourseDetails() {
		return courseDetails;
	}


	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
    
	
	
	
}
