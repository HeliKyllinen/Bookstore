package K24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import K24.Bookstore.domain.Book;
import K24.Bookstore.domain.BookRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
public class JpaTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Book> books = bookRepository.findByAuthor("Lucinda Riley");
		assertThat(books.get(0).getAuthor().equalsIgnoreCase("lucinda riley"));
	}

	@Test
	public void createNewBook() {
		Book book = new Book();
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
    @Test
    public void deleteNewBook() {
		List<Book> books = bookRepository.findByTitle("Sinuhe egyptiläinen");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newBooks = bookRepository.findByTitle("Sinuhe egyptiläinen");
		assertThat(newBooks).hasSize(0);
     }
}
