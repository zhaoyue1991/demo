package com.example.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingApi {

  private static final Logger logger = LoggerFactory.getLogger(GreetingApi.class);

  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
      Model model){
    model.addAttribute("name", name);
    logger.info("name = {}", name);
    return "greeting";
  }

}
