package com.eltontodo.demo.services;

import com.eltontodo.demo.models.Todo;
import com.eltontodo.demo.repos.Todorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private Todorepo trepo;

    @Override
    public List<Todo> findall()
    {
        List<Todo> rtnlist = new ArrayList<>();

        trepo.findAll()
                .iterator()
                .forEachRemaining(rtnlist::add);
        return rtnlist;
    }

    @Override
    public Todo findbyId(long id)
    {
        return trepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + id + " not found"));
    }

    @Transactional
    @Override
    public Todo save(Todo todo)
    {
        Todo newTodo = new Todo();
        newTodo.setDescription(todo.getDescription());
        newTodo.setUser(todo.getUser());

        return trepo.save(newTodo);
    }

    @Transactional
    @Override
    public Todo update(Todo todo, long id)
    {
        return null;
    }
}
