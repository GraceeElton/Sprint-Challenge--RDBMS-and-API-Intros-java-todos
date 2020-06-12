package com.eltontodo.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name= "todo")
public class Todo extends Aud
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column
    private String description;
    private boolean completed;

    @ManyToOne()
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "todo")
    private User user;

    public Todo()
    {

    }

    public Todo(User user, String description)
    {
        this.user = user;
        this.description =description;
    }


    public Todo(String description, boolean completed, User user)
    {
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }


}
