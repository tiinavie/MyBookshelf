package tiina.mybookshelf.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Long> {

	List<Collection> findByTitle(String title);

	List<Collection> findByAuthor(String author);

}
