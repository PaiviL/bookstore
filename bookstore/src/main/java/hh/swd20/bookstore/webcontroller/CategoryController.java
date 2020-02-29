package hh.swd20.bookstore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository catRepository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		List<Category> categories = (List<Category>) catRepository.findAll();
		model.addAttribute("categories", categories);
		return "categorylist";
	}
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addNewCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute Category category) {
		catRepository.save(category);
		return "redirect:/categorylist";
	}

}
