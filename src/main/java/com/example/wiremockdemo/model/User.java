package com.example.wiremockdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Builder
@Setter
@Getter

public class User {

    private String firstName;
    private int age;
    private int id;




}
