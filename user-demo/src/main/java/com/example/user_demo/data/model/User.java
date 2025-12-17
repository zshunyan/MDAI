package com.example.user_demo.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String category;

    public User() {

    }

    public User(Long id, String name, String email, String category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String nombre, String email, String category) {
        this.name = nombre;
        this.email = email;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
