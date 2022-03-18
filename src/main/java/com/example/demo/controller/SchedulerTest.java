package com.example.demo.controller;

import com.example.demo.config.TwitterConfig;
import com.example.demo.domain.Tweet;
import com.example.demo.domain.TweetText;
import com.example.demo.domain.loginuser;
import com.example.demo.enums.TweetStatus;
import com.example.demo.repository.Login_Repository;
import com.example.demo.repository.TweetRepository;
import com.example.demo.repository.TweetTextRepository;
import com.example.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SchedulerTest {


    @Autowired
    private Login_Repository login_repository;

    @Autowired
    private TweetService tweetService;

    @Autowired
    private TwitterStream twitterStream;

    @Autowired
    private TwitterConfig twitterConfig;

    @Autowired
    private com.example.demo.service.usrService userService;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private com.example.demo.service.TweetTextService tweetTextService;

    @Autowired
    private TweetTextRepository tweetTextRepository;

    @org.springframework.beans.factory.annotation.Value("${people.engage.names}")
    private String acs;




}