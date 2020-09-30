package com.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.bootcamp.dao.BootcampRepository;
import com.bootcamp.dao.RoleRepository;
import com.bootcamp.dao.UtilisateurRepository;
import com.bootcamp.entities.Bootcamp;
import com.bootcamp.entities.Role;
import com.bootcamp.entities.Utilisateur;
import com.bootcamp.services.AccountService;

@SpringBootApplication
public class BootcampApplication implements CommandLineRunner {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	 AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}
	@Autowired
	BootcampRepository bootcampRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
}
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Utilisateur.class);
		repositoryRestConfiguration.exposeIdsFor(Role.class);

		
		//add roles
		accountService.saveRole(new Role(1L,"Admin",null));
		accountService.saveRole(new Role(2L,"Publisher",null));
		accountService.saveRole(new Role(3L,"User",null));
	
		Utilisateur admin = new Utilisateur();
		admin.setPassword(bCryptPasswordEncoder.encode("1234"));
		admin.setEmail("admin@hotmail.com");
		admin.setName("admin");

		utilisateurRepository.save(admin);
		accountService.addRoleToUser(admin.getEmail(), "Admin");
		
	}

}
