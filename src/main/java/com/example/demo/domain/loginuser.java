package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Document(collection = "login_user")
public class loginuser {

    @Id
    private String id;
    private String user_email;
    private String password;
    private String user;
    private String status;

    private List<String> nicheSet;

    private List<String> userSet;

}