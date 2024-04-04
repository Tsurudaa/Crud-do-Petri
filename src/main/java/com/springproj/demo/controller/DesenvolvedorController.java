package com.springproj.demo.controller;

import com.springproj.demo.model.Desenvolvedor;
import com.springproj.demo.service.DesenvolvedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/desenvolvedores")
public class DesenvolvedorController {

    @Autowired
    DesenvolvedorService desenvolvedorService;

    @GetMapping
    public List<Desenvolvedor> listDesenvolvedores() {
        return desenvolvedorService.listDesenvolvedores();
    }

    @PostMapping
    public Desenvolvedor criar(@Valid @RequestBody Desenvolvedor desenvolvedor) {
        return desenvolvedorService.criar(desenvolvedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Desenvolvedor desenvolvedor, @PathVariable Long id) {
        if (desenvolvedorService.atualizar(desenvolvedor, id) == null) {
            String message = "id informado inexistente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else {
            return ResponseEntity.ok(desenvolvedor);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(desenvolvedorService.delete(id)) {
            String message = "o id" + id + "foi removido com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            String message = "Id informado inexistente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @GetMapping("/qtdf")
    public int qtdDesenvolvedores() {
    return desenvolvedorService.qtdDesenvolvedores();
    }

    @GetMapping("/{id}")
    public Optional<Desenvolvedor> searchByID(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return desenvolvedorService.searchById(idLong);
    }

    @GetMapping("/buscar-por-nome")
        public List<Desenvolvedor> buscarPorNome(@RequestParam String nome) {
        return desenvolvedorService.buscarPorNome(nome);
    }

}
