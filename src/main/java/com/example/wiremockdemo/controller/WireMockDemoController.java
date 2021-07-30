package com.example.wiremockdemo.controller;

import com.example.wiremockdemo.model.User;
import com.example.wiremockdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController

public class WireMockDemoController {

    @Autowired
    private UserService userService;


    @RequestMapping(method= RequestMethod.POST,path="/user")
    @ResponseBody
    public Mono<User> createUser(@RequestBody User user)
    {
        return   userService.createuser(user);


    }


}
