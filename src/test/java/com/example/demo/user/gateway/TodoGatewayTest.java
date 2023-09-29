package com.example.demo.user.gateway;


import com.example.demo.user.model.TodoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest
@AutoConfigureWireMock(port = 9999)
class TodoGatewayTest {

    @Autowired
    TodoGateway todoGateway;

    @Test
    public void shouldGetTodosFromGateway(){
        // Arrange
        stubFor(get(urlEqualTo("/todos?userId=10"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .withBody("[\n" +
                                "  {\n" +
                                "    \"userId\": 10,\n" +
                                "    \"id\": 1,\n" +
                                "    \"title\": \"delectus aut autem\",\n" +
                                "    \"completed\": false\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"userId\": 10,\n" +
                                "    \"id\": 2,\n" +
                                "    \"title\": \"quis ut nam facilis et officia qui\",\n" +
                                "    \"completed\": false\n" +
                                "  }]"
                        )));

        //Act
        Optional<List<TodoModel>> response = todoGateway.getTodoByUserId(10);

        if(response.isPresent()){
            List<TodoModel> todo = response.get();
            assertEquals(2, todo.size());
        }
    }
}