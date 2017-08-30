package com.example;

import com.example.service.FileSystemStorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.util.FileSystemUtils;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

//  @Bean
//  @Order(value = 1)
//  CommandLineRunner init(FileSystemStorageService fileSystemStorageService){
//    return (args) ->{
//      fileSystemStorageService.deleteAll();
//      fileSystemStorageService.init();
//    };
//  }
}
