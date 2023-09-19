package br.com.hospitalmanagementsystem.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tb_funcionarios")
public class Funcionario extends Pessoa {
    @Email
    /*@Column(length = 60, nullable = false,unique = true)
    @NotBlank(message = "O email deve ser preenchido")*/
    private String email;

    /*@Column(length = 8, nullable = false)*/
    /*@NotBlank(message = "A senha deve ser preenchida")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")*/
    private String pass;

    @Transient
    /*@Column(length = 8, nullable = false)*/
   // @NotBlank(message = "A confirmação de senha deve ser preenchida")
    /*@Size(min = 8, message = "A confirmação de senha deve ter no mínimo 8 caracteres")*/
    private String confirmPass;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="funcionario_Role",
                joinColumns = @JoinColumn(name = "funcionario_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
