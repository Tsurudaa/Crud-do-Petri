package com.springproj.demo.repository;

import com.springproj.demo.model.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignerRepository extends JpaRepository<Designer, Long> {
    List<Designer> findByNomeContaining(String nome);
}
