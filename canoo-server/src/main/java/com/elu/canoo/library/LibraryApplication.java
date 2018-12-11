package com.elu.canoo.library;

import com.elu.canoo.library.models.CanooUser;
import com.elu.canoo.library.models.CanooUserRoles;
import com.elu.canoo.library.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

/*
	@Bean
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			CanooUser admin = new CanooUser();
			admin.setEmail("admin@mail.com");
			admin.setUsername("admin");
			admin.setUserRole(CanooUserRoles.Admin);
			admin.setPassword(encoder.encode("password"));
			repository.save(admin);

			CanooUser user = new CanooUser();
			user.setEmail("librarian@mail.com");
			user.setUsername("librarian");
			user.setUserRole(CanooUserRoles.Librarian);
			user.setPassword(encoder.encode("password"));
			repository.save(user);
		};
	}
*/
}
