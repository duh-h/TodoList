package com.example.apitodolist.repository;


import com.example.apitodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
