package ma.ens.security.spring_jwt_api;

import ma.ens.security.spring_jwt_api.entities.*;
import ma.ens.security.spring_jwt_api.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@SpringBootApplication
public class SpringJwtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApiApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Création des rôles
			Role adminRole = roleRepository.save(new Role(null, "ROLE_ADMIN"));
			Role userRole = roleRepository.save(new Role(null, "ROLE_USER"));

			// Création d'un utilisateur Admin
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("1234")); // On crypte le mdp
			admin.setActive(true);
			admin.getRoles().add(adminRole);
			admin.getRoles().add(userRole);
			userRepository.save(admin);

			System.out.println("Compte de test créé : admin / 1234");
		};
	}
}
