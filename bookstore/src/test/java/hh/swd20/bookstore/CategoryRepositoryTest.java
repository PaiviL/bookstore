package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Test
	public void findByNameReturnsCategory() {
		List<Category> categories = catRepository.findByName("Fantasy");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isEqualTo(4);
	}
	
	@Test
	public void CreateNewCategory() {
		Category category = new Category("Satire");
		catRepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void DeleteOneCategory() {
		List<Category> categories = catRepository.findByName("Fantasy");
		assertThat(categories).hasSize(1);
		catRepository.deleteById(categories.get(0).getCategoryid());
		
		List<Category> categoriesdltd = catRepository.findByName("Fantasy");
		assertThat(categoriesdltd).hasSize(0);
	}

}
