package com.eltontodo.demo.repos;

import com.eltontodo.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>
{

}
