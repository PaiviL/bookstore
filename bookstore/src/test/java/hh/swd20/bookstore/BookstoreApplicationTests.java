package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.webcontroller.BookController;
import hh.swd20.bookstore.webcontroller.CategoryController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookcontroller;
	@Autowired
	private CategoryController catcontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookcontroller).isNotNull();
		assertThat(catcontroller).isNotNull();
	}

}
