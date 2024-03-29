package K24.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByAuthor(String string);

	List<Book> findByTitle(String string);
	
}