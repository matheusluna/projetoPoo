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
 * @author Matheus Moreira Luna
 */
public class Usuario {
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String sexo;
    private String email;
    private String senha;
    private List<Agenda> listaAgendas;
    /**
     * 
     * @param nomeUsuario deve ser passado o nome do usuário a ser criado.
     * @param dataNascimento deve ser passado a data de nascimento do usuário a ser criado.
     * @param sexo deve ser passado o sexo do usuário a ser criado.
     * @param email deve ser passado o e-mail do usuário a ser criado.
     * @param senha deve ser passado a senha do usuário a ser criado.
     */
    public Usuario(String nomeUsuario, LocalDate dataNascimento, String sexo, String email, String senha){
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.listaAgendas = new ArrayList<>();
    }
    /**
     * Função onde se cria uma nova agenda para o usuário. 
     * @param nomeAgenda deve ser passado o nome que a genda deve ter.
     * @return um <code>boolean</code> informando se a agenda foi criada ou não.
     */
    public boolean create(String nomeAgenda){
        for(Agenda a : listaAgendas){
            if(a.getNomeAgenda().equals(nomeAgenda)){
                return false;
            }
        }
        return listaAgendas.add(new Agenda(nomeAgenda));
    }
    /**
     * Função que modifica e informa se o compromisso foi adicionado ou não em determinada agenda.
     * @param compromisso deve ser passado o compromisso com as informações para atualização.
     * @param nome deve ser passado o nome da agenda requerida.
     * @return um <code>boolean</code> informando se foi adicionado ou não.
     */
    public boolean update (Compromisso compromisso, String nome){
        for(Agenda a : listaAgendas){
            if(a.getNomeAgenda().equals(nome)){
                return a.create(compromisso);
            }
        }
        return false;
    }
    /**
     * Função que retorna a agenda requerida.
     * @param nomeAgenda deve ser passado o nome da agenda para pesquisa.
     * @return a <code>Agenda</code> que foi pesquisada ou <code>null</code> se não achar a agenda.
     */
    public Agenda read(String nomeAgenda){
        for(Agenda a : listaAgendas){
            if(a.getNomeAgenda().equals(nomeAgenda)){
                return a;
            }
        }
        return null;
    }
    /**
     * Função que deleta a agenda requerida.
     * @param agenda deve ser passado o objeto agenda para remoção.
     * @return um <code>boolean</code> informando se foi removido ou não.
     */
    public boolean delete(Agenda agenda){
        return listaAgendas.remove(agenda);
    }
    /**
     * Função que retorna o nome do usuário
     * @return um <code>String</code> com o nome do usuário.
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    /**
     * Função que retorna a data de nascimento do usuário.
     * @return um <code>LocalDate</code> com a data de nascimento do usuário.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    /**
     * Função que retorna o sexo do usuário.
     * @return um <code>String</code> com o sexo do usuário.
     */
    public String getSexo() {
        return sexo;
    }
    /**
     * Função que retorna o e-mail do usuário.
     * @return um <code>String</code> com o e-mail do usuário.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Função que retorna a lista de agendas do usuário.
     * @return um <code>List</code> com a lista de agendas do usuário.
     */
    public List<Agenda> getListaAgendas() {
        return listaAgendas;
    }
    /**
     * Procedimento que modifica o nome do usuário.
     * @param nomeUsuario deve ser passado o nome de usuário para modificação.
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    /**
     * Procedimento que modifica a data de nascimento do usuário.
     * @param dataNascimento deve ser passado a data de nascimento de usuário para modificação.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /**
     * Procedimento que modifica o sexo do usuário.
     * @param sexo deve ser passado o sexo de usuário para modificação.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /**
     * Procedimento que modifica o e-mail do usuário.
     * @param email deve ser passado o e-mail de usuário para modificação.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Procedimento que modifica a senha do usuário.
     * @param senha deve ser passado a senha de usuário para modificação.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * Função que autentica se o usuário tem o e-mail e senha em questão.
     * @param email deve ser passado o e-mail para verifivação.
     * @param senha deve ser passado a senha para verificação
     * @return um <code>boolean</code> que diz se a senha e e-mail pertence ou não ao usuário.
     */
    public boolean autenticacaoUsuario(String email, String senha){
        if(this.email.equals(email) && this.senha.equals(senha)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Função que retorna o hashCode do usuário.
     * @return um <code>int</code> informando o código hash do usuário.
     */
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
    /**
     * Função que se um usuário é igual a outro..
     * @param obj deve ser passado um objeto usuario para verificação.
     * @return um <code>booelan</code> identificando se um usuário é igual ao outro.
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
    /**
     * Função que retorna a toString do usuário.
     * @return um <code>String</code> com as informações do usuário.
     */
    @Override
    public String toString() {
        return "Usuario{" + "nomeUsuario=" + nomeUsuario + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", email=" + email + ", listaAgendas=" + listaAgendas + '}';
    }
    
    
    
}
