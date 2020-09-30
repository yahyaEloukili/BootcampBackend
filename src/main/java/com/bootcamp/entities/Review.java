package com.bootcamp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Min(1)
	@Max(10)
	 private int rating;
	
	@ManyToOne
	private Bootcamp bootcamp; 
	
}
