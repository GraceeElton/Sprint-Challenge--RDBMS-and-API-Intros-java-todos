package com.eltontodo.demo.services;

import com.eltontodo.demo.models.User;
import com.eltontodo.demo.views.JustTheCount;

import java.util.List;

public interface UserService
{
    List<User> findall();

    User findbyId(long id);

    // save will handle both post and put
    User save(User user);


    // DELETE
    void delete(long id);

    // check for how many users have todos to do hah
    List<JustTheCount> getCount();



}
