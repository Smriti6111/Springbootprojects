package com.example.app;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.app.user.User;
import com.example.app.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
@Autowired private UserRepository repo;
@Test
public void testAddnew() {
	//run as junittest
	//we can add more users by replacing email,name etc...and passing new values and running it again
	User user=new User();
	user.setEmail("smriti.rani@gmail.com");
	user.setPassword("smriti123");
	user.setFirstName("Smriti");
	user.setLastName("Rani");
//	user.setEmail("sujit.kumar@gmail.com");
//	user.setPassword("sujit123");
//	user.setFirstName("Sujit");
//	user.setLastName("Kumar");
	
	User savedUser=repo.save(user); 
	
	Assertions.assertThat(savedUser).isNotNull();
	Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
}
@Test
public void testListAll() {
	//it will give different users present in database
	Iterable<User> users=repo.findAll();
	Assertions.assertThat(users).hasSizeGreaterThan(0);
	
	for(User user: users) {
		System.out.println(user);
	}
}
@Test
public void testUpdate() {
	//it will show the updated password in database
	Integer userId=1;
	Optional<User> optionalUser=repo.findById(userId);
    User user=optionalUser.get();
    user.setPassword("sujit2000");
    repo.save(user);
    
    User updatedUser=repo.findById(userId).get();
    Assertions.assertThat(updatedUser.getPassword()).isEqualTo("smriti2000"); 
}
@Test
public void testGet() {
	//it will give the details of user having id =2 in console
	Integer userId=2;
	Optional<User> optionalUser=repo.findById(userId);
    Assertions.assertThat(optionalUser).isPresent();
    System.out.println(optionalUser.get());
}
@Test
public void testDelete() {
	//running this method will delete the user id 2 from database
	Integer userId=2;
	repo.deleteById(userId);
	Optional<User> optionalUser=repo.findById(userId);
    Assertions.assertThat(optionalUser).isNotPresent();
}
}
