package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
    public void sayHi(String name){
       System.out.println("Hi " + name);
    }
}
