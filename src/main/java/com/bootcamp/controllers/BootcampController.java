package com.bootcamp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.dao.BootcampRepository;
import com.bootcamp.dao.CourseRepository;
import com.bootcamp.entities.Course;

@RestController
public class BootcampController {
@Autowired
BootcampRepository bootcampRepo;
@Autowired
CourseRepository courseRepo;
	@PostMapping("/v2/createCourse")
	public Course createCourse(@Valid @RequestBody Course course) {
		course.setBootcamp(bootcampRepo.findById(course.getBootcampId()).get());
		return courseRepo.save(course);
	}
}
