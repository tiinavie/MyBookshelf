package tiina.mybookshelf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tiina.mybookshelf.domain.Category;
import tiina.mybookshelf.domain.CategoryRepository;
import tiina.mybookshelf.domain.Collection;
import tiina.mybookshelf.domain.CollectionRepository;
import tiina.mybookshelf.domain.User;
import tiina.mybookshelf.domain.UserRepository;

@SpringBootApplication
public class MybookshelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybookshelfApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookshelfDemo(CollectionRepository cRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {
			Category category1 = new Category("Fantasy");
			categoryRepository.save(category1);
			Category category2 = new Category("Horror");
			categoryRepository.save(category2);
			Category category3 = new Category("YA");
			categoryRepository.save(category3);
			Category category4 = new Category("Romance");
			categoryRepository.save(category4);

			cRepository.save(new Collection("Alice Isn\'t Dead", "Joseph Fink", 2018, category2, "not read"));
			cRepository.save(new Collection("Welcome to Night Vale", "Joseph Fink & Jeffrey Cranor", 2015, category2,
					"finished"));
			cRepository.save(new Collection("It Devours!", "Joseph Fink & Jeffrey Cranor", 2017, category2, "reading"));
			cRepository.save(new Collection("Coraline", "Neil Gaiman", 2002, category2, "finished"));
			cRepository.save(new Collection("The Graveyard Book", "Neil Gaiman", 2008, category1, "finished"));
			cRepository.save(new Collection("American Gods", "Neil Gaiman", 2001, category1, "finished"));

			// users: admin/admin and user/user
			User user1 = new User("owner", "$2a$10$V3GwmSjIWoL7HBVIFleg6.q4Kq41wAeC0PVabpdA8ewoQdTzbQrr6", "OWNER");
			userRepository.save(user1);

		};
	};
}