package com.eltontodo.demo.contollers;

import com.eltontodo.demo.models.Todo;
import com.eltontodo.demo.repos.Todorepo;
import com.eltontodo.demo.services.TodoService;
import com.eltontodo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/todos")
public class TodoContoller
{

    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;
    // GETS later ha

//     POST http://localhost:2019/todos/user/4 IT MOTHER FUCKKKING WORKS!
    // i need to pull in the user service lame
    @PostMapping(value = "/user/{id}", consumes = {"application/json"})
    public ResponseEntity<?> addnewTodo(@RequestBody Todo newTodo, @PathVariable long id)
    {
        newTodo.setUser(userService.findbyId(id));
        return new ResponseEntity<>(todoService.save(newTodo) , HttpStatus.CREATED);
    }

   // PATCH // WORRRKKKIIINGGG!!!
    @PatchMapping(value = "/todo/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long id)
    {
        return new ResponseEntity<>(todoService.update(updateTodo, id),HttpStatus.CREATED );
    }






}
