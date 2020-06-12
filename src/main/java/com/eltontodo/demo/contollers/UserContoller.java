package com.eltontodo.demo.contollers;


import com.eltontodo.demo.models.User;
import com.eltontodo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserContoller
{
    @Autowired
    private UserService userService;
    // getters

    // working!!!
    // http://localhost:2019/users/users
    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        List<User> allUsers = userService.findall();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);

    }

    // WORKING AHHH

    // http://localhost:2019/users/user/4
    @GetMapping(value = "/user/{id}", produces = {"application/json"})
    public ResponseEntity<?> listUserById(@PathVariable long id)
    {
        User u = userService.findbyId(id);
                return new ResponseEntity<>(u, HttpStatus.OK);
    }

        //Working!!
    //POST http://localhost:2019/users/user
    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> addnewUser(@Valid @RequestBody User newUser)
    {
        newUser.setUserid(0);
        newUser = userService.save(newUser);
        HttpHeaders responseHeaders = new HttpHeaders();

        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newUser .getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);
        return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
    }

    // working!! SO happy!

    // DELETE http://localhost:2019/users/userid/10
    @DeleteMapping(value = "/userid/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // get http://localhost:2019/users/users/todos with query selectors

    @GetMapping(value = "/users/todos", produces = {"application/json"})
    public ResponseEntity<?> count()
    {
        return new ResponseEntity<>(userService.getCount(), HttpStatus.OK);
    }

}
