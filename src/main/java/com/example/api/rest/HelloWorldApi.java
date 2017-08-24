package com.example.api.rest;

import com.example.entity.User;
import com.example.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author zhaoyue
 * @RestController 以json格式输出
 */
@RestController
public class HelloWorldApi {

  @Resource
  private UserService userService;

  @ApiOperation(value = "hello测试", notes = "hello测试")
  @GetMapping("/hello")
  public String index() {
    return "Hello World";
  }

  @GetMapping("/getUser")
  @ApiOperation(value = "查询单个用户", notes = "查询单个用户")
  public User getUser(@RequestParam(value = "userName") final String userName) {
    return userService.selectUser(userName);
  }

  @GetMapping("getUsers")
  @ApiOperation(value = "查询全部用户", notes = "查询单个用户")
  public List<User> getUsers(){
    return  userService.selectUserList();
  }
}
