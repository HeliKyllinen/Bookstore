package K24.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import K24.Bookstore.domain.AppUser;
import K24.Bookstore.domain.AppUserRepository;
import K24.Bookstore.domain.Book;
import K24.Bookstore.domain.BookRepository;
import K24.Bookstore.domain.Category;
import K24.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	/*
	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryrepository, AppUserRepository arepository) {
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
			
			AppUser user1 = new AppUser("user", "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By","hh@.fi", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$/U9C/cQ7sudkeFkJS7OUwOfbIoWEzQPLeMd7cI8RgSfxChyKkNeVu", "pp@.fi", "ADMIN");
			arepository.save(user1);
			arepository.save(user2);
			
			
			System.out.println("Tulostetaan demodata");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	*/

}
