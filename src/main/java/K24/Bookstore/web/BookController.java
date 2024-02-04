package K24.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import K24.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	

	
	@GetMapping("/booklist")
	public String showBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
}
