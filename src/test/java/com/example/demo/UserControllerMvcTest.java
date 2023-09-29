package com.example.demo;

import com.example.demo.greeting.LotteryService;
import com.example.demo.user.gateway.TodoGateway;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LotteryService lotteryService;

    @MockBean
    UserService userService;

    @MockBean
    TodoGateway todoGateway;

    @Test
    void shouldBeAbleToCallUsers() throws Exception {
       when(userService.get()).thenReturn(List.of());

       String result = mockMvc.perform(get("/users"))
               .andExpect(status().isOk())
               .andReturn()
               .getResponse().getContentAsString();

       assertEquals("[]", result);
    }

    @Test
    void shouldBeAbleToCallUsersById() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setAge(18);
        userDto.setName("user 10");
        userDto.setId(10);

        when(userService.get(10)).thenReturn(userDto);

        String result = mockMvc.perform(get("/users/10"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

        assertEquals("{\"id\":10,\"name\":\"user 10\",\"age\":18}", result);
    }
}
