package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.domain.loginuser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Login_Repository extends MongoRepository<loginuser, String>  {
}
