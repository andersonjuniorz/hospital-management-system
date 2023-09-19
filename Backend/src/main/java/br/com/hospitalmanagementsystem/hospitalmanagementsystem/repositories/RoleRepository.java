package br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
