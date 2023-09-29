package com.example.demo;

import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;

    @Test
    public void shouldThrowNotFoundExceptionIfUserRepoReturnEmpty() {
        when(userRepo.findById(10)).thenReturn(Optional.empty());
        UserService userService = new UserService(userRepo);

        Assertions.assertThrows(UserNotFoundException.class, ()-> {
            userService.get(10);
        });
    }
}
