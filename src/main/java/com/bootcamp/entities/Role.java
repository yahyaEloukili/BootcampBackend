package com.bootcamp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public class Role  implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	

    private String name;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    @JsonIgnore	
    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
}
