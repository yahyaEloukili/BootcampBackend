package com.bootcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.dao.CourseRepository;
import com.bootcamp.entities.Course;

@Service
public interface ResourceService {

	public List<Course> getCourses();
	
}
