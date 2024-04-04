package com.springproj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.springproj.demo.model.Desenvolvedor;
import com.springproj.demo.repository.DesenvolvedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedorService {

    @Autowired
    DesenvolvedorRepository desenvolvedorRepository;

    public List<Desenvolvedor> listDesenvolvedores() {
        return desenvolvedorRepository.findAll();
    }

    public Desenvolvedor criar(Desenvolvedor desenvolvedor) {
        return desenvolvedorRepository.save(desenvolvedor);
    }

    public Desenvolvedor atualizar(Desenvolvedor desenvolvedor, Long id) {
        if (checkID(id)) {
            desenvolvedor.setId(id);
            return desenvolvedorRepository.save(desenvolvedor);
        }
        return null;
    }

    private boolean checkID(Long id) {
        if (desenvolvedorRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long id) {
        if(checkID(id)) {
            desenvolvedorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int qtdDesenvolvedores() {
        return desenvolvedorRepository.findAll().size();
    }

    public Optional<Desenvolvedor> searchById(Long id) {
        return desenvolvedorRepository.findById(id);
    }

    public List<Desenvolvedor> buscarPorNome(String nome) {
        return desenvolvedorRepository.findByNomeContaining(nome);
    }
}
