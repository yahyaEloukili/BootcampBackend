package com.bootcamp.services;

import com.bootcamp.entities.Role;
import com.bootcamp.entities.Utilisateur;

public interface AccountService {

	
	Role saveRole(Role role);
	void addRoleToUser(String email, String roleName);
	Utilisateur findUserByEmail(String email);

	

	
}
