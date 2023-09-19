package br.com.hospitalmanagementsystem.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@MappedSuperclass
@Data
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String num;

    private LocalDateTime dataRegistro;
}
