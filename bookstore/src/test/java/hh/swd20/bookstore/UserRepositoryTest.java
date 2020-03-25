package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUsernameReturnsUser() {
		User user = userRepository.findByUsername("user");
		assertThat(user.getEmail()).isEqualTo("user1@users.com");
	}
	
	@Test
	public void CreateNewUser() {
		User user = new User("testuser", "$2a$10$YZdKsp/niD04kmBTx.mM3ekQKp3s.o8TbU0iqXbL2VaNC/uLASyYW", 
				"testuser@users.com", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void DeleteOneUser() {
		User user = userRepository.findByUsername("user");
		userRepository.deleteById(user.getId());
		User userdltd = userRepository.findByUsername("user");
		assertThat(userdltd).isNull();
	}

}
