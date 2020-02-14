package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	// Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa toteuttavan luokan olion 
	// ja kytkee olion BookController-luokasta luodun olion attribuuttiolioksi
	@Autowired
	BookRepository bookRepository;
	
	// http://localhost:8080/index
	@RequestMapping("/index")
	public String sayWelcome() {
		return "index";
	}

}
