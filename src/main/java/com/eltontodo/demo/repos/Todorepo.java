package com.eltontodo.demo.repos;

import com.eltontodo.demo.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface Todorepo extends CrudRepository<Todo ,Long>
{

}
