package com.bootcamp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.bootcamp.dao.CourseRepository;
import com.bootcamp.services.ResourceService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public class Course {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	//@NotNull(message = "Please add a title")
	private String title;
	//@NotNull(message = "Please add a description")
	private String description;
	//@NotNull(message = "Please add a weeks")
	private String 	weeks;
//	@NotNull(message = "Please add a tuition")
	private double	tuition;
	//@NotNull(message = "Please add a minimum skill")
	private String minimumSkill;
	private Boolean skolarshipAvailable = false;
	@ManyToOne
	@JsonIgnore
	private Bootcamp bootcamp;
	private transient Long  bootcampId;
	

	
}
