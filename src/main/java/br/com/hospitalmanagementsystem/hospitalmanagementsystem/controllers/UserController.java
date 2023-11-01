package br.com.hospitalmanagementsystem.hospitalmanagementsystem.controllers;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.User;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/usuarios")
    public List<User> findAll() {
        return userService.findAll();
    }
}
