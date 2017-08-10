package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.UserRepository;
import com.example.mdl.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa1"));
		
	}
	
	@Test
	public void query() {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(1, 10, sort);
		userRepository.findAll(pageable);
	}
}
