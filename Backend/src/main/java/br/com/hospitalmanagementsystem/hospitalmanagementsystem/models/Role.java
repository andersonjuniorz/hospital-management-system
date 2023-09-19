package br.com.hospitalmanagementsystem.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;
}
