package K24.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import K24.Bookstore.domain.Book;
import K24.Bookstore.domain.BookRepository;
import K24.Bookstore.domain.Category;
import K24.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryrepository) {
		return (args) -> {
			
			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Romance");
			Category category3 = new Category("Historical fiction");
				
			categoryrepository.save(category1);
	        categoryrepository.save(category2);
	        categoryrepository.save(category3);
			
			System.out.println("save some books");
			bookRepository.save(new Book("Harry Potter ja viisastenkivi", "J.K. Rowling", "9789520420581", 1997, 28.90, category1 ));
			bookRepository.save(new Book("Atlas, Papa Saltin tarina", "Lucinda Riley", "9789524034302", 2023, 11.90, category2 ));
			bookRepository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", "9789510098752", 1945, 18.50, category3 ));
			
			System.out.println("Tulostetaan demodata");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
