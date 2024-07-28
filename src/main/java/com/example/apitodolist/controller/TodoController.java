package com.example.apitodolist.controller;

import com.example.apitodolist.entity.Todo;
import com.example.apitodolist.service.TodoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);

    }
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
