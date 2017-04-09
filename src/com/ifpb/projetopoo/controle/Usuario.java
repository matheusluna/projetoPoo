/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return true;
    }
    
}
