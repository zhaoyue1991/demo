package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class UserService {

  @Resource
  private UserRepository userRepository;

  public User selectUser(String userName){
    return userRepository.findByUserName(userName);
  }

  public List<User> selectUserList(){
    return userRepository.findAll();
  }
}
