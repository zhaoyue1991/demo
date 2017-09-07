package com.example.api.rest;

import com.example.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class WebApi extends WebMvcConfigurerAdapter {


  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/results").setViewName("results");
  }

  @GetMapping("/showForm")
  public String showForm(User user){
    return "form";
  }

  @PostMapping("/checkUserInfo")
  public String checkUserInfo(@Valid User user, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      return "form";
    }
    return "redirect:/results";
  }
}

