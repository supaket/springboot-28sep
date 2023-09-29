package com.example.demo.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyRandomTest {

    @Mock
    Random random;

    @Test
    public void shouldReturnNumber5IfRandom() {

        //Arrange //stub
        when(random.nextInt(10)).thenReturn(5);

        //ACT
        int result = random.nextInt(10);

        //Assert
        assertEquals(result, 5);

    }

    @Test
    public void shouldCallRandomNextInt1Times() {
        //Arrange
        Random spy007 = spy(new Random());

        //Act
        spy007.nextInt(10);
        spy007.nextInt(10);

        //Assert
        verify(spy007, times(2)).nextInt(10);

    }


    @Test
    public void shouldCallRandomWithParam10(){
        //Arrange
        Random spy007 = spy(new Random());

        //Act
        spy007.nextInt(10);

        //Assert
        ArgumentCaptor<Integer> argumentCapture = ArgumentCaptor.forClass(Integer.class);
        verify(spy007).nextInt(argumentCapture.capture());

        int value = argumentCapture.getValue();

        assertEquals(10, value);

    }
}