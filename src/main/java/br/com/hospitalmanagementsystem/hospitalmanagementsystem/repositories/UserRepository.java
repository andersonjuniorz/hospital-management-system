package br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByEmail(String email);
}
