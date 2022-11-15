package tiina.mybookshelf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tiina.mybookshelf.domain.Category;
import tiina.mybookshelf.domain.CategoryRepository;
import tiina.mybookshelf.domain.Collection;
import tiina.mybookshelf.domain.CollectionRepository;
import tiina.mybookshelf.domain.Readstatus;
import tiina.mybookshelf.domain.ReadstatusRepository;
import tiina.mybookshelf.domain.User;
import tiina.mybookshelf.domain.UserRepository;

@SpringBootApplication
public class MybookshelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybookshelfApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookshelfDemo(CollectionRepository cRepository, ReadstatusRepository rsRepository,
			CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			Category category1 = new Category("Fantasy");
			categoryRepository.save(category1);
			Category category2 = new Category("Horror");
			categoryRepository.save(category2);
			Category category3 = new Category("YA");
			categoryRepository.save(category3);
			Category category4 = new Category("Nonfiction");
			categoryRepository.save(category4);

			Readstatus readstatus1 = new Readstatus("Not read");
			rsRepository.save(readstatus1);
			Readstatus readstatus2 = new Readstatus("Reading");
			rsRepository.save(readstatus2);
			Readstatus readstatus3 = new Readstatus("Finished");
			rsRepository.save(readstatus3);

			cRepository.save(new Collection("The October Man", "Ben Aaronovitch", 2019, category1, readstatus1));
			cRepository.save(new Collection("The Furthest Station", "Ben Aaronovitch", 2017, category1, readstatus1));
			cRepository.save(new Collection("Tolkienin Tulkkina", "Kersti Juva", 2021, category4, readstatus2));
			cRepository.save(new Collection("Coraline", "Neil Gaiman", 2002, category2, readstatus3));
			cRepository.save(new Collection("The Graveyard Book", "Neil Gaiman", 2008, category1, readstatus3));
			cRepository.save(new Collection("American Gods", "Neil Gaiman", 2001, category1, readstatus3));
			cRepository.save(new Collection("A Darker Shade of Magic", "V. E. Schwab", 2015, category1, readstatus1));
			cRepository.save(new Collection("Love in Vein", "Poppy Z. Brite", 2000, category2, readstatus1));
			cRepository.save(
					new Collection("The Light at the End", "John Skipp & Graig Spector", 2015, category2, readstatus1));
			cRepository.save(new Collection("Kumma Kirjoitusopas", "Osuuskumma", 2022, category4, readstatus2));

			// users: admin/admin and user/user
			User user1 = new User("owner", "$2a$10$V3GwmSjIWoL7HBVIFleg6.q4Kq41wAeC0PVabpdA8ewoQdTzbQrr6", "OWNER");
			userRepository.save(user1);

		};
	};
}