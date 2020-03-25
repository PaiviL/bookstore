package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository catRepository;
	
	@Test
	public void findByTitleReturnsBook() {
		List<Book> books = bookRepository.findByTitle("Animal Farm");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	
	@Test
	public void CreateNewBook() {
		Book book = new Book("Ennen päivänlaskua ei voi", "Johanna Sinisalo", 2000, 
				"978-951-31-6071-5", 8.90, catRepository.findByName("Fantasy").get(0));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void DeleteOneBook() {
		List<Book> books = bookRepository.findByTitle("Animal Farm");
		assertThat(books).hasSize(1);
		bookRepository.deleteById(books.get(0).getId());
		
		List<Book> booksdltd = bookRepository.findByTitle("Animal Farm");
		assertThat(booksdltd).hasSize(0);
	}

}
