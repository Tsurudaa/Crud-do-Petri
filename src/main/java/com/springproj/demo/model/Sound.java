package com.springproj.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sound extends Desenvolvedor{
    private String setor;

    public Sound() {
    }

    public Sound(String nome, String cpf, double salario, String setor) {
        super(nome, cpf, salario);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}