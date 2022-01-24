package com.example.demo.demo.services;

import com.example.demo.demo.model.Products;
import com.example.demo.demo.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getUser();
    public User updateUser(String id, User user);
    public void deleteUser(String id);
}
