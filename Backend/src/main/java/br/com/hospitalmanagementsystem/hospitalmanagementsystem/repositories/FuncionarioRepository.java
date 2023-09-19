package br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Override
    List<Funcionario> findAll();
}
