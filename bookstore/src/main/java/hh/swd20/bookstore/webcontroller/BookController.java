package hh.swd20.bookstore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	// Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa toteuttavan luokan olion 
	// ja kytkee olion BookController-luokasta luodun olion attribuuttiolioksi
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository catRepository;
	
	// http://localhost:8080/index
	@RequestMapping("/index")
	public String sayWelcome() {
		return "index";
	}
	
	// kirjalistaus
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll(); // kirjojen haku tietokannasta
		model.addAttribute("books", books); // kirjalistan välitys templatelle model-olion avulla
		return "booklist"; 					// booklist-templaten kutsuminen
	}
	
	// tyhjä kirjalomake
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addNewBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
	}
	
	// lomakkeella syötettyjen tietojen tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);			// talletetaan kirjan tiedot tietokantaan
		return "redirect:/booklist"; 		// palataan kirjalistaan, /booklist-endpointin kutsu
	}
	
	// kirjan poisto
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id) { 
		bookRepository.deleteById(id);		// poistetaan kirja tietokannasta id:n perusteella
		return "redirect:../booklist";		// palataan kirjalistaan, /booklist-endpointin kutsu
	}
	
	// kirjan muokkaus
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		// kirjan haku tietokannasta id:n perusteella, ja välitys templatelle model-olion avulla
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("categories", catRepository.findAll());
		return "editbook";					// editbook-templaten kutsuminen
	}

}
