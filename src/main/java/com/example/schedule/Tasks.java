package com.example.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Tasks {

  private static final Logger logger = LoggerFactory.getLogger(Tasks.class);

  private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime(){
    logger.info("The time is {}", format.format(new Date()));
  }
}
