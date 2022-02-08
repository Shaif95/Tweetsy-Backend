package com.example.demo.domain;

import com.example.demo.enums.TweetStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

@Data
@Document(collection = "Tweet_Text")
public class TweetText {

    @Id
    private String id;
    private String user;
    private String userid;       //username
    private String text;      //description
    private TweetStatus status;
    private  Long duration;
    private String date;
    private String time;

}
