/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mathe
 */
public class Usuario {
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String sexo;
    private String email;
    private String senha;
    private List<Agenda> listaAgendas;
    
    public Usuario(String nomeUsuario, LocalDate dataNascimento, String sexo, String email, String senha){
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.listaAgendas = new ArrayList<>();
    }
    
    public boolean create(String nomeAgenda){
        for(Agenda a : listaAgendas){
            if(a.getNome().equals(nomeAgenda)){
                return false;
            }
        }
        return listaAgendas.add(new Agenda(nomeAgenda));
    }

    public boolean update (Compromisso c, String nome){
        for(Agenda a : listaAgendas){
            if(a.getNome().equals(nome)){
                return a.create(c);
            }
        }
        return false;
    }
     
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Agenda> getListaAgendas() {
        return listaAgendas;
    }
    
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 17 * hash + Objects.hashCode(this.dataNascimento);
        hash = 17 * hash + Objects.hashCode(this.sexo);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + Objects.hashCode(this.listaAgendas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.listaAgendas, other.listaAgendas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nomeUsuario=" + nomeUsuario + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", email=" + email + ", listaAgendas=" + listaAgendas + '}';
    }
    
    
    
}
