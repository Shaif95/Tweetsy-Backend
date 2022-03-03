package com.example.demo.service;


import com.example.demo.config.TwitterConfig;
import com.example.demo.domain.loginuser;
import com.example.demo.repository.Login_Repository;
import com.example.demo.utils.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private Login_Repository login_repository;

    @Autowired
    private TwitterConfig twitterConfig;

    @Value("${twitter.consumer.key}")
    private String consumerKey;

    @Value("${twitter.consumer.secret}")
    private String consumerSecret;

    public loginuser add(loginuser user) {
        return login_repository.save(user);
    }

    public Map<String, Object> findWithPaging(Integer page, Integer size) {
        Page<loginuser> users = login_repository.findAll(PageRequest.of(page, size));

        Map<String, Object> usersMap = new HashMap<>();
        usersMap.put("users", users.getContent());
        usersMap.put("pages", users.getTotalPages());

        return usersMap;
    }

    public List<loginuser> findByEmail(String id) {
        return  login_repository.findByUser(id);
    }


    public loginuser updateByEmail(String id, loginuser updatedUser) {

        loginuser user = login_repository.findByUser(id).get(0);

        CustomBeanUtils.copyNonNullProperties(updatedUser, user);

        return login_repository.save(user);

    }

    public loginuser update(String id, loginuser updatedUser) {

        loginuser user = login_repository.findById(id).get();

        CustomBeanUtils.copyNonNullProperties(updatedUser, user);

        return login_repository.save(user);

    }

    public loginuser updateFollowSet(String id, String acs) {

        loginuser user = login_repository.findById(id).get();

        String [] fset = acs.split(",");

        user.setFollowSet(Arrays.asList(fset));

        return login_repository.save(user);

    }

    public loginuser findById(String id) {
        return login_repository.findById(id).get();
    }

    public void delete(String id) {
        login_repository.deleteById(id);
    }

}
