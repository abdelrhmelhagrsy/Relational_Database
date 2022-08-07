package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table
public class CourseDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseDetailsID;
	private String start_date;
	private String end_date;
	private String content_url;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "fk_courseID",referencedColumnName = "courseID")
	private Course course;
	
	
	
	public CourseDetails() {
		super();
	}


	public CourseDetails(String start_date, String end_date, String content_url, Course course) {
		super();
		this.start_date = start_date;
		this.end_date = end_date;
		this.content_url = content_url;
		this.course = course;
	}


	public int getCourseDetailsID() {
		return courseDetailsID;
	}


	public void setCourseDetailsID(int courseDetailsID) {
		this.courseDetailsID = courseDetailsID;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public String getContent_url() {
		return content_url;
	}


	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
