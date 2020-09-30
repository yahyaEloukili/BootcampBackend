package com.bootcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.dao.CourseRepository;
import com.bootcamp.entities.Course;

public class ResourceServiceImpl  implements ResourceService{
	@Autowired
	CourseRepository courseRepository;
	@Override
	public List<Course> getCourses() {
		
		return courseRepository.findAll();
	}

}
