package com.bootcamp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Persistent;




@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public class Bootcamp implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
     @NotNull(message = "Please add a name")
     @Column(unique = true)
     @Size(max = 50,message = "Name can't be more then 50 characters")
     private String name;
     
     private String slug ;
     @NotNull(message = "Please add a description")
     @Size(max = 50,message = "Description can't be more then 500 characters")
     private String description;
     private String website;
     
     @Size(max = 20,message = "Phone number can't be more then 20 characters")
     private String phone;
     @NotNull(message = "Please add an adress")
     private String address;
     private String formattedAddress;
     private String carrer;
     private String street ;
     private String city;
     private String state;
     private String zipcode;
     private String  country;
     private double averageRating;
     private double averageCost;
     private String photo = "no-photo.jpg";
     private Boolean housing = false;
     private Boolean jobAssistance = false;
     private Boolean jobGuarantee = false;
     private Boolean acceptGi = false;
     
     @OneToMany(mappedBy = "bootcamp")
     private List<Course> courses = new ArrayList<Course>();
     @OneToMany(mappedBy = "bootcamp")
     private List<Review> reviews = new ArrayList<Review>();
     private static final transient Pattern NONLATIN = Pattern.compile("[^\\w-]");
     private static final transient Pattern WHITESPACE = Pattern.compile("[\\s]");
     @PrePersist
     public void createSlug() {
    	 String nowhitespace = WHITESPACE.matcher(this.getName()).replaceAll("-");
    	    String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
    	    String slug = NONLATIN.matcher(normalized).replaceAll("");
    	    setSlug(slug.toLowerCase(Locale.ENGLISH));
     }
     
     
}
