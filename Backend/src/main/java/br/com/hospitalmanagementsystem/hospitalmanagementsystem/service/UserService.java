package br.com.hospitalmanagementsystem.hospitalmanagementsystem.service;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.User;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
