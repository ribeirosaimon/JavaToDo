package br.com.saimon.javatodo.controllers;

import br.com.saimon.javatodo.models.entities.User;
import br.com.saimon.javatodo.models.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUser(){
        List<User> listUsers = new ArrayList<>();
        for (User users:repository.findAll()) {
            listUsers.add(users);
        }
        return ResponseEntity.ok(listUsers);
    }
}
