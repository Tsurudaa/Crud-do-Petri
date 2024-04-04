package com.springproj.demo.service;

import com.springproj.demo.model.Designer;
import com.springproj.demo.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignerService {

    @Autowired
    DesignerRepository designerRepository;

    public List<Designer> listDesigners() {
        return designerRepository.findAll();
    }

    public Designer criar(Designer designer) {
        return designerRepository.save(designer);
    }

    public Designer atualizar(Designer designer, Long id) {
        if (checkID(id)) {
            designer.setId(id);
            return designerRepository.save(designer);
        }
        return null;
    }

    private boolean checkID(Long id) {
        if(designerRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long id) {
        if(checkID(id)) {
            designerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int qtdDesigners() {
        return designerRepository.findAll().size();
    }

    public Optional<Designer> searchByID(Long id) {
        return designerRepository.findById(id);
    }

    public List<Designer> buscarPorNome(String nome) {
        return designerRepository.findByNomeContaining(nome);
    }
}
