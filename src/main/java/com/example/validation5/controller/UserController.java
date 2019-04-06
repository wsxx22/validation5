package com.example.validation5.controller;

import com.example.validation5.entity.User;
import com.example.validation5.exception.PeselExistsException;
import com.example.validation5.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/add")
    public User addUser (@RequestBody @Valid User user) {
        return userRepo.save(user);
    }

    @GetMapping
    public List<User> showUsers () {
        return userRepo.findAll();
    }

//    @GetMapping("/check/{pesel}")


}
