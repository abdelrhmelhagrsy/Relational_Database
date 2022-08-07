package com.example.demo.Controllers;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
