package K24.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import K24.Bookstore.domain.BookRepository;
import K24.Bookstore.domain.Category;
import K24.Bookstore.domain.CategoryRepository;

public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;	
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/categorylist")
	public String showCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category() );
		//model.addAttribute("categories", categoryRepository.findAll());
		return "addcategory";
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryRepository.save(category);
		return "redirect:/categorylist";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id, Model model) {
		categoryRepository.deleteById(id);
		return "redirect:/categorylist"; 
	}
	
	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editCategory", categoryRepository.findById(id));
		//model.addAttribute("categories", categoryRepository.findAll());
		return "editBook"; 
	}

}
