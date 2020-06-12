package com.eltontodo.demo.repos;

import com.eltontodo.demo.models.User;
import com.eltontodo.demo.views.JustTheCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long>
{
        //SELECT COUNT *
        //FROM Users
        // WHERE completed = false


    @Query(value = "SELECT u.username, count(t.todoid) FROM user u JOIN todo t ON u.userid = t.userid WHERE NOT t.completed BY u.username", nativeQuery = true)
    List<JustTheCount> getCountTodo();



}
