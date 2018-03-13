package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findDistinctByEmailAndPassword(String email, String password);

}
