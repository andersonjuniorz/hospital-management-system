package br.com.hospitalmanagementsystem.hospitalmanagementsystem.Dto;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.UserRole;

public record RegisterUserWithRoleDto(String username, String email, String password, UserRole role) {}
