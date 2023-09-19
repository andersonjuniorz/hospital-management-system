package br.com.hospitalmanagementsystem.hospitalmanagementsystem.service;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Funcionario;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    //Encontrar usuario por id
    public ResponseEntity<Object> findById(Integer id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioOptional.get());
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
    public void delete(Funcionario funcionario){
        funcionarioRepository.delete(funcionario);
    }

    public void save(Funcionario funcionario){
        funcionario.setDataRegistro(LocalDateTime.now());
        funcionarioRepository.save(funcionario);
    }
    public Funcionario update(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

}
