package com.eltontodo.demo.services;

import com.eltontodo.demo.models.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findall();

    Todo findbyId(long id);

    // save PUT
    Todo save(Todo todo);


   // PATCH

    Todo update(Todo todo, long id);


}
