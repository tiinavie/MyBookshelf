package tiina.mybookshelf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tiina.mybookshelf.domain.CategoryRepository;
import tiina.mybookshelf.domain.Collection;
import tiina.mybookshelf.domain.CollectionRepository;
import tiina.mybookshelf.domain.UserRepository;

@Controller
public class CollectionController {
	@Autowired
	private CollectionRepository cRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Show all books in Thymeleaf template
	@RequestMapping(value = "/collection", method = RequestMethod.GET)
	public String collection(Model model) {
		model.addAttribute("books", cRepository.findAll());
		return "collection";
	}

	// RESTful service to get all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Collection> collectionRest() {
		return (List<Collection>) cRepository.findAll();
	}

	// RESTful service to get books by id
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Collection> findBookRest(@PathVariable("id") Long bookId) {
		return cRepository.findById(bookId);
	}

	// Add new book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Collection());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	// Save new book to the collection
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Collection book) {
		cRepository.save(book);
		return "redirect:collection";
	}

	// Delete a book from collection
	@PreAuthorize("hasAuthority('OWNER')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		cRepository.deleteById(bookId);
		return "redirect:../collection";
	}

	// Edit a book from collection
	@PreAuthorize("hasAuthority('OWNER')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", cRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}

}
