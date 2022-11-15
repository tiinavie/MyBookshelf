package tiina.mybookshelf;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tiina.mybookshelf.domain.Collection;
import tiina.mybookshelf.domain.CollectionRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private CollectionRepository bookRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Collection> books = bookRepository.findByAuthor("Neil Gaiman");

		assertThat(books).hasSize(3);
		assertThat(books.get(0).getTitle()).isEqualTo("Coraline");
	}

	@Test
	public void createNewBook() {
		Collection book = new Collection("Café Con Lychee", "Emery Lee", 2022, null, null);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
