package K24.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import K24.Bookstore.domain.Book;
import K24.Bookstore.domain.BookRepository;
import K24.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/booklist")
	public String showBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book() );
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist"; 
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editBook", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook"; 
	}
	
}
