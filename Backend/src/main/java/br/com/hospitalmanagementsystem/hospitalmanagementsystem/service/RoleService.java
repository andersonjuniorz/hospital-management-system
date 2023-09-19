package br.com.hospitalmanagementsystem.hospitalmanagementsystem.service;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Role;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
}
