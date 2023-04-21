package com.example.securitysystemcoreservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String content;

    public Greeting(){
        this.content = "Hello %s";
    }

    public static Greeting makeCompleteGreeting(String name){
        Greeting greeting = new Greeting();
        greeting.content = String.format(greeting.content, name);
        return greeting;
    }

}