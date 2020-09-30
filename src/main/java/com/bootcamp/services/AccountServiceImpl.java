package com.bootcamp.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.RoleRepository;
import com.bootcamp.dao.UtilisateurRepository;
import com.bootcamp.entities.Role;
import com.bootcamp.entities.Utilisateur;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	 @Autowired
	    private UtilisateurRepository utilisateurRepository;
	    @Autowired
	    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Role role = roleRepository.findByName(roleName);
        Utilisateur user = utilisateurRepository.findByEmail(email);
        user.getRoles().add(role);
    }

    @Override
    public Utilisateur findUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }


}
