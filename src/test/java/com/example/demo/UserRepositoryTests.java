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

import com.example.repository.UserRepository;
import com.example.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void test() throws Exception {
    Date date = new Date();

    User user1 = User.builder().userName("a1").email("aa@126.com").passWord("123456").nickName("aa").regTime(date)
        .build();
    User user2 = User.builder().userName("b1").email("bb@126.com").passWord("123456").nickName("bb").regTime(date)
        .build();
    User user3 = User.builder().userName("c1").email("cc@126.com").passWord("123456").nickName("cc").regTime(date)
        .build();
    userRepository.save(user1);
    userRepository.save(user2);
    userRepository.save(user3);
  }

  @Test
  public void query() {
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(1, 10, sort);
    userRepository.findAll(pageable);
  }
}
