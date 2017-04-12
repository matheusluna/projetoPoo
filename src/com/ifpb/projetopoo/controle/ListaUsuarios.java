/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.controle;

import com.ifpb.projetopoo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mathe
 */
public class ListaUsuarios {
    private List<Usuario> listaUsuarios;
    
    public ListaUsuarios(){
        this.listaUsuarios = new ArrayList<>();
    }
    
    public boolean create(Usuario u){
        for(Usuario aux : listaUsuarios){
            if(u.equals(aux))return false;    
        }
        return listaUsuarios.add(u);
    }
    
    public boolean delete(Usuario u){
        return listaUsuarios.remove(u);
    }
    
    public Usuario read(String email, String senha){
        for(Usuario u : listaUsuarios){
            if(email.equals(u.getEmail()) && senha.equals(u.getSenha())) return u;
        }
        return null;
    }
    
    public boolean update (Usuario u){
        for(int i = 0; i < listaUsuarios.size(); i ++){
            if(listaUsuarios.get(i).equals(u)){
                listaUsuarios.set(i, u);
                return true;
            }   
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.listaUsuarios);
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
        final ListaUsuarios other = (ListaUsuarios) obj;
        if (!Objects.equals(this.listaUsuarios, other.listaUsuarios)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListaUsuarios{" + "listaUsuarios=" + listaUsuarios + '}';
    }
    
    
}
