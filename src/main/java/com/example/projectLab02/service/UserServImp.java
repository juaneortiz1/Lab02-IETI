package com.example.projectLab02.service;

import com.example.projectLab02.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServImp implements UserService{
    private final Map<Long, User> userMap = new HashMap<>();
    private long nextId = 1;


    @Override
    public User createUser(User user) {
        user.setId(nextId++);
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userMap.containsKey(id)){
            user.setId(id);
            userMap.put(id, user);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMap.remove(id) != null;
    }
}
