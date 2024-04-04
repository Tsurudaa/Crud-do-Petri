package com.springproj.demo.service;

import com.springproj.demo.model.Sound;
import com.springproj.demo.repository.SoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoundService {

    @Autowired
    SoundRepository soundRepository;

    public List<Sound> listSound() {
        return soundRepository.findAll();
    }

    public Sound criar(Sound sound) {
        return soundRepository.save(sound);
    }

    public Sound atualizar(Sound sound, Long id) {
        if (checkID(id)) {
            sound.setId(id);
            return soundRepository.save(sound);
        }
        return null;
    }

    private boolean checkID(Long id) {
        if(soundRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long id) {
        if(checkID(id)) {
            soundRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int qtdSounds() {
        return soundRepository.findAll().size();
    }

    public Optional<Sound> searchByID(Long id) {
        return soundRepository.findById(id);
    }

    public List<Sound> buscarPorNome(String nome) {
        return soundRepository.findByNomeContaining(nome);
    }
}
