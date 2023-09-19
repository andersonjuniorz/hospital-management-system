package br.com.hospitalmanagementsystem.hospitalmanagementsystem.controllers;

import br.com.hospitalmanagementsystem.hospitalmanagementsystem.models.Funcionario;
import br.com.hospitalmanagementsystem.hospitalmanagementsystem.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }
    @GetMapping("/funcionario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        return funcionarioService.findById(id);
    }
    @DeleteMapping("/funcionario")
    public void delete(@RequestBody Funcionario funcionario) {
        funcionarioService.delete(funcionario);
    }
    @PostMapping("/funcionario")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Funcionario funcionario) {
        funcionarioService.save(funcionario);
    }
    @PutMapping("/funcionario")
    public Funcionario update(@RequestBody Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

}
