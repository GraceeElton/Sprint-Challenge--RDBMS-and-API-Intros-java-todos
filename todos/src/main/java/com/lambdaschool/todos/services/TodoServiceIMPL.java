package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodoServiceIMPL implements TodosService
{
    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserService userService;


    @Override
    public Todos save(Todos newTodo, long userid)
    {

        User currentUser = userService.findUserById(userid);

        Todos savedTodo = new Todos(currentUser, newTodo.getDescription());

        todoRepo.save(savedTodo);

        return savedTodo;
    }

    @Override
    public Todos markComplete(long todoid)
    {
        Todos currentTodo = todoRepo.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " not found"));

       currentTodo.setIscompleted(true);

        return todoRepo.save(currentTodo);
    }


}
