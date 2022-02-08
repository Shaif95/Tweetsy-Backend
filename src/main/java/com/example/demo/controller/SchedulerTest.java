package com.example.demo.controller;

import com.example.demo.domain.Tweet;
import com.example.demo.domain.TweetText;
import com.example.demo.enums.TweetStatus;
import com.example.demo.repository.TweetTextRepository;
import com.example.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import static java.util.concurrent.TimeUnit.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

@RestController
public class SchedulerTest {

    @Autowired
    private TweetTextRepository tweetTextRepository;

    @Autowired
    private TweetService tweetService;

    @Autowired
    private com.example.demo.service.usrService userService;

//    @Scheduled(cron =" 0 0 */12 * * ?")
  //  public void name() throws TwitterException {

        //System.out.println("HI");



    //}






}