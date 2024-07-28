package com.example.apitodolist.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Todo() {
    }
    public Todo(String name, String descricao, boolean realizado, int prioridade){
        this.name = name;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.realizado = realizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
