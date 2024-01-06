package com.function.api.resource;

import com.function.api.model.Comment;
import com.function.api.model.Todo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class Controller {

  private static final String URI = "https://jsonplaceholder.typicode.com/";
  private final RestClient restClient = RestClient.create();

  @GetMapping("/hello")
  public String hello(@RequestParam String name) {
    return "Hello " + name + " " + LocalDateTime.now();
  }

  @GetMapping("/comments")
  public ResponseEntity<List<Comment>> getComments() {

    return restClient
        .get()
        .uri(URI + "comments")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .toEntity(new ParameterizedTypeReference<List<Comment>>() {});
  }

  @GetMapping("/todos")
  public ResponseEntity<List<Todo>> getTodos() {

    return restClient
        .get()
        .uri(URI + "todos")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .toEntity(new ParameterizedTypeReference<List<Todo>>() {});
  }
}
