package tiina.mybookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiina.mybookshelf.domain.Category;
import tiina.mybookshelf.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	// Show all categories
	@RequestMapping(value = "/categorylist")
	public String categorylist(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}

	// Add a category
	@RequestMapping(value = "/addcat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	// Save new category to the category list
	@RequestMapping(value = "/catsave", method = RequestMethod.POST)
	public String save(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}

}
