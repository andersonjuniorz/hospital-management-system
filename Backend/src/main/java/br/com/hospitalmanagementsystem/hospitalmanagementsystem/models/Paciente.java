package br.com.hospitalmanagementsystem.hospitalmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pacientes")
public class Paciente extends Pessoa {
    private String responsavel;
}
