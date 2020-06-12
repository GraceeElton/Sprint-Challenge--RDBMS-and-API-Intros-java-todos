package com.eltontodo.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String primaryemail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "user")
    private List<Todo> todos = new ArrayList<>();


    public User()
    {
    }

    public User(String username, String password, @Email String primaryemail)
    {
        this.username = username;
        this.password = password;
        this.primaryemail = primaryemail;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrimaryemail()
    {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail;
    }

    public List<Todo> getTodos()
    {
        return todos;
    }

    public void setTodos(List<Todo> todo)
    {
        this.todos = todos;
    }
}
