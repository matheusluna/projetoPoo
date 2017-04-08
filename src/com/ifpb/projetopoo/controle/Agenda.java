/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.controle;

import com.ifpb.projetopoo.modelo.Compromisso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class Agenda {
    private String nomeAgenda;
    private List<Compromisso> listaEventos;
    
    public Agenda(String nome){
        this.nomeAgenda = nome;
        this.listaEventos = new ArrayList<>();
    }
    
    public boolean create(Compromisso compromisso){
        for(Compromisso c : listaEventos){
            if((c.getData().equals(compromisso.getData())) && (c.getDescricao().equals(compromisso.getDescricao())) && (c.getHora().equals(compromisso.getHora())) && (c.getLocal().equals(compromisso.getLocal()))) return false; 
        }
        return listaEventos.add(compromisso);
    }
    
    public Compromisso read(String descricao){
        for(Compromisso c : listaEventos){
            if(c.getDescricao().equals(descricao))return c;
        }
        return null;
    }
    
    public boolean update (Compromisso c){
        for(int i = 0; i < listaEventos.size(); i++){
            if(listaEventos.get(i).getDescricao().equals(c)){
                listaEventos.set(i, c);
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(Compromisso c){
        return listaEventos.remove(c);
    }
    
    public void atualizaNomeAgenda(String nome){
        this.nomeAgenda = nome;
    }
}
