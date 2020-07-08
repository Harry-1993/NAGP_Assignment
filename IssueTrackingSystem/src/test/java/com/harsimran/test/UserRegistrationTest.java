package com.harsimran.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.harsimran.auth.model.User;
import com.harsimran.auth.repository.UserRepository;

@DataJpaTest
public class UserRegistrationTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserRepository userRepo;

	@Test
	public void testSaveNewUser() {
		entityManager.persist(new User("harry_new", "asdf1234", "asdf1234"));
		User user = userRepo.findByUsername("harry_new");
		assertThat(user.getUsername()).isEqualTo("harry_new");

	}

}
