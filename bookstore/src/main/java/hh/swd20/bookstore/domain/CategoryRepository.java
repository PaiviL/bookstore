package hh.swd20.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//tietokantakäsittelyn rajapinta
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// Parametrisoinnissa annetaan Entity luokan nimi Category ja pääavaimen luokkatietotyyppi Long
	List<Category> findByName(String name); //

}
