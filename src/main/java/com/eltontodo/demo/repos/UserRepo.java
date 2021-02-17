package com.eltontodo.demo.repos;

import com.eltontodo.demo.models.User;
import com.eltontodo.demo.views.UserCountTodos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long>
{
        //SELECT COUNT *
        //FROM Users

        // WHERE completed = false

    //@Query(value = "SELECT u.username as usernamerpt, count(t.todoid) as counttodos FROM users u JOIN todos t ON u.userid = t.userid WHERE NOT t.completed GROUP BY u.username ORDER BY u.username", nativeQuery = true)
    @Query(value = "SELECT u.username as usernamerpt, count(t.todoid) as counttodos FROM user u JOIN todo t ON u.userid = t.userid WHERE NOT t.completed GROUP BY u.username ORDER BY u.username", nativeQuery = true)

    List<UserCountTodos> getCountTodo();





}
