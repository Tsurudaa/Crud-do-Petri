package com.springproj.demo.controller;

import com.springproj.demo.model.Sound;
import com.springproj.demo.service.SoundService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sounds")
public class SoundController {

    @Autowired
    SoundService soundService;

    @GetMapping
    public List<Sound> listSound() {
        return soundService.listSound();
    }
    @PostMapping
    public Sound criar(@Valid @RequestBody Sound sound) {
        return soundService.criar(sound);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Sound sound, @PathVariable Long id) {
        if(soundService.atualizar(sound, id) == null) {
            String message = "Id informado inexistente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else {
            return ResponseEntity.ok(sound);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(soundService.delete(id)) {
            String message = "o id" + id + "foi removido com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            String message = "Id informado inexistente";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @GetMapping("/qtds")
    public int qtdSound() {
        return soundService.qtdSounds();
    }

    @GetMapping("/{id}")
    public Optional<Sound> searchByID(@PathVariable Long id) {
        return soundService.searchByID(id);
    }

    @GetMapping("/buscar-por-nome")
    public List<Sound> buscarPorNome(@RequestParam String nome) {
        return soundService.buscarPorNome(nome);
    }
}