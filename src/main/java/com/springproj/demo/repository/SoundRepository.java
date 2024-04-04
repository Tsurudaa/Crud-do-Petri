package com.springproj.demo.repository;

import com.springproj.demo.model.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoundRepository extends JpaRepository<Sound, Long> {
    List<Sound> findByNomeContaining(String nome);
}
