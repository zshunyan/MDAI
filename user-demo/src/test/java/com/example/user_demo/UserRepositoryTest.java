package com.example.user_demo;

import com.example.user_demo.data.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.user_demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    void findByNameStartingWith(){
        User user1 = new User("Juan", "juan@email.com");
        User user2 = new User("Pedro", "pedro@email.com");
        userRepo.save(user1);
        System.out.println("Usuario añadido: " + user1);
        userRepo.save(user2);
        System.out.println("Usuario añadido: " + user2);
        // Buscar usuarios cuyo nombre empieza por "J"
        List<User> users = userRepo.findByNameStartingWith("J");
        System.out.println("Usuarios encontrados: " + users);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals("Juan", users.get(0).getName());
    }


    @Test
    void findByUsername() {
        User user= new User("John Doe", "john.email.com");
        userRepo.save(user);
        User fetchedUser = userRepo.findById(user.getId()).orElse(null);
        Assertions.assertNotNull(fetchedUser);
        Assertions.assertEquals("John Doe", fetchedUser.getName());
    }

    @Test
    void findByCategoryAndEmail() {
        User user1 = new User("Ana", "ana@email.com", "admin");
        User user2 = new User("Luis", "luis@email.com", "user");
        User user3 = new User("Maria", "ana@email.com", "admin");
        userRepo.save(user1);
        System.out.println("Usuario añadido: " + user1);
        userRepo.save(user2);
        System.out.println("Usuario añadido: " + user2);
        userRepo.save(user3);
        System.out.println("Usuario añadido: " + user3);
        // Buscar usuarios con categoria "admin" y email "ana@email.com"
        Iterable<User> result = userRepo.findByCategoryAndEmail("admin", "ana@email.com");
        List<User> users = new ArrayList<>();
        result.forEach(users::add);
        System.out.println("Usuarios encontrados: " + users);
        Assertions.assertEquals(2, users.size());
        for (User u : users) {
            Assertions.assertEquals("admin", u.getCategory());
            Assertions.assertEquals("ana@email.com", u.getEmail());
        }
    }

    @Test
    void findByEmailQuery() {
        User user1 = new User("Carlos", "carlos@email.com", "admin");
        User user2 = new User("Lucia", "lucia@email.com", "user");
        User user3 = new User("Pedro", "carlos@email.com", "user");
        userRepo.save(user1);
        System.out.println("Usuario añadido: " + user1);
        userRepo.save(user2);
        System.out.println("Usuario añadido: " + user2);
        userRepo.save(user3);
        System.out.println("Usuario añadido: " + user3);
        // Buscar usuarios por email usando el método con @Query
        List<User> users = userRepo.findByEmail("carlos@email.com");
        System.out.println("Usuarios encontrados por email: " + users);
        Assertions.assertEquals(2, users.size());
        for (User u : users) {
            Assertions.assertEquals("carlos@email.com", u.getEmail());
        }
    }
}
