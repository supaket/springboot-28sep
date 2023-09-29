package com.example.demo.fizzbuzz;

import com.example.demo.FizzBuzz.FizzBuzz;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void shouldSayFizzWhenDivideByThree(){
        // AAA

        // Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Act
        String result = fizzBuzz.say(3);

        // Assert
        assertEquals("Fizz",result);
    }

    @Test
    public void shouldSayBuzzWhenDivideByFive(){

        // Arrange
       FizzBuzz fizzBuzz = new FizzBuzz();

        int divideByFive = 5* (new Random().nextInt(10) +1);
       // Act
        String result = fizzBuzz.say(divideByFive);

        //Assert
        assertEquals("Buzz", result);

    }

    @Test
    public void shouldSayNumberWhenNotDivideByThreeOrFive() {
        //arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(1);

        //Assert

        assertEquals(new Integer(1).toString(), result);
    }

    @Test
    public void shouldSayFizzBuzzWhenAbleToDivideByThreeAndFive() {
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(15);

        //Assert
        assertEquals("FizzBuzz", result);

    }
}
