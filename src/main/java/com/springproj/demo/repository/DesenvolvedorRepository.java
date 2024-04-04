package com.springproj.demo.repository;

import com.springproj.demo.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
    List<Desenvolvedor> findByNomeContaining(String nome);
}