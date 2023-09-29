package com.example.demo.FizzBuzz;

public class FizzBuzz {
    public String say(int i) {

        String result = "";

        if(i %3 ==0) {
            result += "Fizz";
        }

        if(i % 5 ==0) {
           result += "Buzz";
        }

        if(result =="") {
            result = new Integer(i).toString();
        }

        return result;
    }
}
