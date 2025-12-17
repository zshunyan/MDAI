package com.example.user_demo.data.repository;

import com.example.user_demo.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameStartingWith(String prefix);

    Iterable<User> findByCategoryAndEmail(String category, String email);

    @Query ("SELECT u FROM User u WHERE u.email = ?1" )
    List<User> findByEmail(String email);

}
