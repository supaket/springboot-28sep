package com.example.demo;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;


//    @AfterAll
//    public void tearDown() {
//        userRepository.deleteAll();
//    }

    @Test
    void shouldBySaveAndFetchUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("user 10");
        userEntity.setAge(18);


        userRepository.save(userEntity);

        Optional<UserEntity> user = userRepository.findById(1);

        assertEquals("user 10", user.get().getName());

    }
}
