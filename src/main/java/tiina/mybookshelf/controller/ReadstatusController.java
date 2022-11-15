package tiina.mybookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tiina.mybookshelf.domain.ReadstatusRepository;

@Controller
public class ReadstatusController {
	@Autowired
	private ReadstatusRepository readstatusRepository;

	// Show all categories
	@RequestMapping(value = "/readstatus")
	public String readstatus(Model model) {
		model.addAttribute("readstatuses", readstatusRepository.findAll());
		return "readstatus";
	}

}
