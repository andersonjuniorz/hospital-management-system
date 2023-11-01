package br.com.hospitalmanagementsystem.hospitalmanagementsystem.controllers;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.Dto.AuthenticationDto;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.Dto.LoginResponseDto;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.Dto.RegisterUserDto;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.Dto.RegisterUserWithRoleDto;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.Security.TokenService;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.User;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.UserRole;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var loginPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(loginPassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return  ResponseEntity.ok(new LoginResponseDto(token));
    }

    /* Cadastro de usuarios comuns (Paciente) - Usando essa rota qualquer um consegue criar conta,
    todos sera automaticamente cadastrado com a role user */
    @PostMapping("/cadastrar-paciente")
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid RegisterUserDto data){
        if(this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        UserRole role = UserRole.valueOf("USER");

        String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptPassword, role);

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    /* Cadastro de usuarios (Atendente, admins) - Usando essa rota apenas funcionarios autenticados,
    com token ativo e role admin podem cadastrar novos usuarios */
    @PostMapping("/cadastrar-usuario")
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid RegisterUserWithRoleDto data){
        if(this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptPassword, data.role());

        System.out.println(newUser);
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
