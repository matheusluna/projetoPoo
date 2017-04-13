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
 * @author Matheus Moreira Luna
 */
public class ListaUsuarios {
    private List<Usuario> listaUsuarios;
    
    public ListaUsuarios(){
        this.listaUsuarios = new ArrayList<>();
    }
    /**
     * Função de criação de usuário e incremento na lista.
     * @param usuario deve ser passado um objeto de usuário para incremento.
     * @return um <code>boolean</code> informando se o usuário foi adicionado ou não.
     */
    public boolean create(Usuario usuario){
        for(Usuario aux : listaUsuarios){
            if(usuario.equals(aux))return false;    
        }
        return listaUsuarios.add(usuario);
    }
    /**
     * Função de remoção de usuários.
     * @param usuario deve ser passado um objeto de usuário para deletar.
     * @return um <code>boolean</code> informadno se o usuário foi removido ou não.
     */
    public boolean delete(Usuario usuario){
        return listaUsuarios.remove(usuario);
    }
    /**
     * Função de pesquisa de usuários a partir do e-mail e senha.
     * @param email deve ser passado o e-mail do usuário que deseja pesquisar.
     * @param senha deve ser passado a senha do usuário que deseja pesquisar.
     * @return um <code>Usuario</code> com as informações do usuário pesquisado.
     */
    public Usuario read(String email, String senha){
        for(Usuario u : listaUsuarios){
            if(u.autenticacaoUsuario(email, senha)) return u;
        }
        return null;
    }
    /**
     * Função que atualiza as informações do usuário em questão.
     * @param usuario deve ser passado um objeto de usuário com as informações atualizadas.
     * @param email deve ser passado o e-mail para pesquisa.
     * @return um <code>boolean</code> confirmando se o usuário foi atualizado ou não.
     */
    public boolean update (Usuario usuario, String email){
        for(int i = 0; i < listaUsuarios.size(); i ++){
            if(listaUsuarios.get(i).getEmail().equals(email)){
                listaUsuarios.set(i, usuario);
                return true;
            }   
        }
        return false;
    }
    /**
     * Função que retorna o código hash da lista de usuários.
     * @return um <code>int</code> com o código da lista.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.listaUsuarios);
        return hash;
    }
    /**
     * Função de comparação de listas de usuários.
     * @param obj deve ser passado um objeto de ListaUsuarios para verificação.
     * @return um <code>boolean</code> que informa se os objetos são iguais ou não.
     */
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
    /**
     * Função que informa o toString da lista.
     * @return um <code>String</code> coms as informações da lista.
     */
    @Override
    public String toString() {
        return "ListaUsuarios{" + "listaUsuarios=" + listaUsuarios + '}';
    }
    
    
}
