package com.eltontodo.demo.services;

import com.eltontodo.demo.models.Todo;
import com.eltontodo.demo.models.User;
import com.eltontodo.demo.repos.UserRepo;
import com.eltontodo.demo.views.UserCountTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo urepo;

    @Override
    public List<User> findall()
    {

         List<User> rtnList = new ArrayList<>();

        urepo.findAll()
                .iterator()
                .forEachRemaining(rtnList :: add);
        return rtnList;
    }

    @Override
    public User findbyId(long id)
    {
        return urepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " not found"));
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail());

        // lists
        for(Todo t : user.getTodos())
        {
            Todo newTodo = new Todo(newUser, t.getDescription());
            newUser.getTodos().add(newTodo);
        }

        return urepo.save(newUser);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if(urepo.findById(id).isPresent())
        {
            urepo.deleteById(id);
        }else
        {
            throw new EntityNotFoundException("User " + id + " not found");
        }

    }
//    @Transactional
//    @Override
//    public List<JustTheCount> getCount()
//    {
//
//    }

    @Override
    public List<UserCountTodos> getCountoftodos()
    {
        return urepo.getCountTodo();
    }

    @Override
    public List<UserCountTodos> getusernamerpt()
    {
        return urepo.getCountTodo();
    }
}
