package com.bootcamp.dao;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bootcamp.entities.Bootcamp;
import com.bootcamp.entities.Course;

@CrossOrigin(value = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH} )
@RepositoryRestResource
public  interface CourseRepository extends JpaRepository<Course, Long>{




}
