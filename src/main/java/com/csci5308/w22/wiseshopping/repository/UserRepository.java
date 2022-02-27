package com.csci5308.w22.wiseshopping.repository;

import com.csci5308.w22.wiseshopping.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pavithra Gunasekaran
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
   //@Query("select u from user_details u where u.email = ?1 and u.password = ?2")
    List<User> findByEmailAndPassword(String email, String password);
    User getUserByEmail(String email);
    User getUserById(Integer userId);
}
