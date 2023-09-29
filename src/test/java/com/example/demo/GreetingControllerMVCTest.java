package com.example.demo;

import com.example.demo.greeting.LotteryService;
import com.example.demo.user.gateway.TodoGateway;
import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GreetingControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LotteryService lotteryService;

    @MockBean
    UserService service;

    @MockBean
    TodoGateway todoGateway;

    @Test
    public void shouldAbleToCallGreeting() throws Exception {
        when(lotteryService.checkLotto(10)).thenReturn(true);

        this.mockMvc.perform(post("/Greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"tomz\", \"lotto\":9}"))
                .andExpect(status().isOk());

    }
}
