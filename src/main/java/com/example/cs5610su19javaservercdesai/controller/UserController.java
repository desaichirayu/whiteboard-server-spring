package com.example.cs5610su19javaservercdesai.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.cs5610su19javaservercdesai.utils.UserSearchUtils;
import org.springframework.web.bind.annotation.*;

import com.example.cs5610su19javaservercdesai.models.User;

@RestController
public class UserController {
    static List<User> users = new ArrayList<>();
    private static final String corsUrl = "http://cs5610-su19-java-server-cdesai.herokuapp.com";
    static long userIndex;
    static {
        users.add(new User(0, "alice", "password", "Alice", "Vaughn", "FACULTY"));
        users.add(new User(1, "bob", "password", "Bod", "Marley", "STUDENT"));
        users.add(new User(2, "charlie", "password", "Charlie", "Harper", "ADMIN"));
        users.add(new User(3, "dan", "password", "Daniel", "Rhodes", "STUDENT"));
        users.add(new User(4, "charlie", "password", "Charlie", "Harper",  "ADMIN"));
        users.add(new User(5, "charlie", "password", "Charlie", "Harper", "STUDENT"));
        users.add(new User(6, "charlotte", "password", "Charlotte", "Richards", "FACULTY"));
        userIndex = users.size();
    }
    // CRUD
    
    // POST - Creating
    @CrossOrigin(origins = corsUrl)
    @PostMapping("/api/users")
    public List<User> createUser(@RequestBody User user) {
        user.setId(++userIndex);
        users.add(user);
        return users;
    }
    
    // GET - Reading
    @CrossOrigin(origins = corsUrl)
    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return users;
    }

    // GET - Reading
    @CrossOrigin(origins = corsUrl)
    @GetMapping("/api/users/{id}")
    public User findUserById(@PathVariable("id") long id) {
        for (User user: users ) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @CrossOrigin(origins = corsUrl)
    @PostMapping("api/users/search")
    public List<User> searchUser(@RequestBody User user){
        System.out.println(user);
        UserSearchUtils userSearchUtils = new UserSearchUtils();
        try {
            userSearchUtils.initializeCriteria(user);
            return userSearchUtils.doSearch(users, user);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // UPDATE - Updating
    @CrossOrigin(origins = corsUrl)
    @PutMapping("/api/users/{id}")
    public List<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        User oldUser = findUserById(id);
        int index = users.indexOf(oldUser);
        users.remove(index);
        users.add(index, user);
        return users;
    }

    // DELETE - Deleting
    @CrossOrigin(origins = corsUrl)
    @DeleteMapping("/api/users/{id}")
    public List<User> deleteUser(@PathVariable("id") long id){
        User user = findUserById(id);
        if(user != null){
            users.remove(user);
        }
        return users;
    }
}
