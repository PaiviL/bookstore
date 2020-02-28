package hh.swd20.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

//tietokantakäsittelyn rajapinta
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// Parametrisoinnissa annetaan Entity luokan nimi Category ja pääavaimen luokkatietotyyppi Long

}
