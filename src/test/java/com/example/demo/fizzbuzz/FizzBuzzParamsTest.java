package com.example.demo.fizzbuzz;

import com.example.demo.FizzBuzz.FizzBuzz;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzParamsTest {

    @ParameterizedTest
    @ValueSource (ints = {3, 6, 9})
    public void shouldSayFizzWhenDivideByThree(int input) {
        // AAA

        // Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Act
        String result = fizzBuzz.say(input);

        // Assert
        assertEquals("Fizz", result);

    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    public void shouldSayBuzzWhenDivideByFive(int input){

        // Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        // Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals("Buzz", result);


    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,7,8})
    public void shouldSayNumberWhenNotDivideByThreeOrFive(int input) {
        //arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(input);

        //Assert

        assertEquals(new Integer(input).toString(), result);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30})
    public void shouldSayFizzBuzzWhenAbleToDivideByThreeAndFive(int input) {
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals("FizzBuzz", result);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "2, 2",
        "3, Fizz",
        "4, 4",
        "5, Buzz",
        "6, Fizz",
        "7, 7",
        "8, 8",
        "9, Fizz",
        "10, Buzz",
        "15, FizzBuzz"
    })
   public void shouldSayFizzBuzzOrNumberAsInputProvide(int input, String expected) {
       //Arrange
       FizzBuzz fizzBuzz = new FizzBuzz();

       //ACT
       String result = fizzBuzz.say(input);

       //Assert
        assertEquals(expected, result);

   }

}