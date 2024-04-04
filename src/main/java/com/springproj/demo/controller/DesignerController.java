package com.springproj.demo.controller;


import com.springproj.demo.model.Designer;
import com.springproj.demo.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/designers")
public class DesignerController {

    @Autowired
    DesignerService designerService;

    @GetMapping
    public List<Designer> listDesigners() {
        return designerService.listDesigners();
    }

    @PostMapping
    public Designer create(@RequestBody Designer designer) {
        return designerService.criar(designer);
    }

    @PutMapping("/{id}")
    public Designer update(@RequestBody Designer designer, @PathVariable Long id) {
        return designerService.atualizar(designer, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable Long id) {
        return designerService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Designer> getById(@PathVariable Long id) {
        return designerService.searchByID(id);
    }

    @GetMapping("/buscar-por-nome")
    public List<Designer> buscarPorNome(@RequestParam String nome) {
        return designerService.buscarPorNome(nome);
    }
}