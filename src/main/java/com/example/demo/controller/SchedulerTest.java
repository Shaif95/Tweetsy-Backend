package com.example.demo.controller;

import com.example.demo.domain.Tweet;
import com.example.demo.domain.TweetText;
import com.example.demo.enums.TweetStatus;
import com.example.demo.repository.TweetTextRepository;
import com.example.demo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import javax.servlet.ServletException;

import static java.util.concurrent.TimeUnit.*;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

@RestController
public class SchedulerTest {


    @Autowired
    private TweetService tweetService;

    @Autowired
    private com.example.demo.service.usrService userService;

    @Autowired
    private com.example.demo.service.TweetTextService tweetTextService;

    @Autowired
    private TweetTextRepository tweetTextRepository;

   @Scheduled(cron ="0 */3 * * * ?")
   public void schl() throws TwitterException, ServletException, IOException, InterruptedException {

        System.out.println("HI......................................");

       Instant now = Instant.now();

       //System.out.println(now);
       Instant min_1 = now.plus(1,ChronoUnit.MINUTES);
       Instant min_2 = now.plus(2,ChronoUnit.MINUTES);
       Instant min_3 = now.plus(3,ChronoUnit.MINUTES);
       Instant min_4 = now.plus(4,ChronoUnit.MINUTES);

       String date = now.toString().substring(2,19);
       String date1 = min_1.toString().substring(2,19);
       String date2 = min_2.toString().substring(2,19);
       String date3 = min_3.toString().substring(2,19);
       String date4 = min_4.toString().substring(2,19);

       find(date,0);
       find(date1,1);
       find(date2,2);
       //find(date3,3);
       //find(date4,4);


       System.out.println(date);
       //System.out.println(date1);

       System.out.println("........................................");

    }

    private void find(String date, Integer k) throws ServletException, IOException, TwitterException, InterruptedException {
       List<TweetText> tweets = tweetTextRepository.findBydatetime(date,TweetStatus.PENDING);

       System.out.println(tweets);

       for(int i =0; i<tweets.size();i++)
       {
           //Thread.sleep((k*1000*60));

           TweetText t = tweets.get(i);

           userService.post(t.getUserid(),t.getText());

           t.setStatus(TweetStatus.SENT);

           TweetText t1 = tweetTextService.update(tweets.get(i).getId(),t);
       }

    }


}