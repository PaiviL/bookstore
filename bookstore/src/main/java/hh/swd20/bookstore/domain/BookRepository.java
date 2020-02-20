package hh.swd20.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

//tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository<Book, Long> {
	// CrudRepository rajapinnan parametrisoinnissa annetaan Entity luokan nimi Book
	// toisena parametrina pääavainsarakkeen luokkatietotyyppi Long
	// BookRepository periytyy (extends) CrudRepositorystä ja perii sen metodiesittelyt

}
