package com.example.demo.demo.services;

import com.example.demo.demo.model.Products;
import com.example.demo.demo.model.User;
import com.example.demo.demo.repository.ProductRepository;
import com.example.demo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String id, User user) {
        Optional<User> findById = userRepository.findById(Long.valueOf(String.valueOf(id)));
        if (findById.isPresent()) {
            User UserEntity = findById.get();
            if (user.getEmail() != null && !user.getEmail().isEmpty())
                UserEntity.setEmail(user.getEmail());
            if (user.getPassword() != null)
                UserEntity.setPassword(user.getPassword());
            if (user.getActive() != null)
                UserEntity.setActive(user.getActive());
            return userRepository.save(UserEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(Long.valueOf(id));
    }


}
