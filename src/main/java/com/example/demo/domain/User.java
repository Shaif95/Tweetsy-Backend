package com.example.demo.domain;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String user;
    private String userid;//username
    private Long count;

    private String token;
    private String token_secret;

    private String status;

    private String top_weekly;
    private String top_monthly;

    private Long rt_weekly;
    private Long rt_monthly;

    private Long fav_weekly;
    private Long fav_monthly;
}
