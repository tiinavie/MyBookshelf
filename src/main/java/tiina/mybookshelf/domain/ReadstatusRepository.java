package tiina.mybookshelf.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReadstatusRepository extends CrudRepository<Readstatus, Long> {

	List<Readstatus> findByName(String name);

}