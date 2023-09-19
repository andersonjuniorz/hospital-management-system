package br.com.hospitalmanagementsystem.hospitalmanagementsystem.controllers;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Role;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
