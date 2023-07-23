package com.psuedovert.spring.scheduler.api.service;

import com.psuedovert.spring.scheduler.api.dao.UserRepo;
import com.psuedovert.spring.scheduler.api.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private Random random = new Random();

    //Schedule a job to add object in DB every 5sec
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("user" + random.nextInt(34343));
        userRepo.save(user);
        log.info("add service call in " + new Date());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<User> users = userRepo.findAll();
        log.info("fetch service call in " + new Date());
        log.info("no of records fetched: " + users.size());
        log.info("users : {}", users);
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello there! App is working.";
    }

}