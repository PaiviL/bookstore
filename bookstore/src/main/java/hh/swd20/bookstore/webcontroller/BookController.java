package hh.swd20.bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	// http://localhost:8080/index
	@RequestMapping("/index")
	public String sayWelcome() {
		return "index";
	}

}
