package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository catRepository) {
		return (args) -> {
			log.info("save a couple of books");
			catRepository.save(new Category("Political fiction"));
			catRepository.save(new Category("Historical fiction"));
			catRepository.save(new Category("Science fiction"));
			catRepository.save(new Category("Fantasy"));
			
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "978-0-141-03613-7", 8.90));
			bookRepository.save(new Book("Nineteen Eighty-Four", "George Orwell", 1949, "978-0-451-52493-5", 10.90));
			bookRepository.save(new Book("All the Light We Cannot See", "Anthony Doerr", 2014, "978-1-4767-4658-6", 14.90));
			
			log.info("fetch all categories");
			for (Category category : catRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
