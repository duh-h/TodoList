package com.example.apitodolist;

import com.example.apitodolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiToDoListApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateSuccess() {
        var todo = new Todo("1","2",false,1);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());

    }

    @Test
    void testCreateFailure() {
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(
                        new Todo("","",false,0)
                ).exchange()
                .expectStatus().isBadRequest();

    }

}
