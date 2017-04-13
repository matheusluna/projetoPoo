
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Matheus Moreira Luna
 */
public class Agenda {
    
    private String nomeAgenda;
    private List<Compromisso> listaEventos;
    /**
     * 
     * @param nome recebe o nome que deve ser dado a agentda
     */
    public Agenda(String nome){
        this.nomeAgenda = nome;
        this.listaEventos = new ArrayList<>();
    }
    /**
     * Função que retorna o nome da agenda.
     * @return um <code>String</code> com o nome da agenda.
     */
    public String getNomeAgenda() {
        return nomeAgenda;
    }
    /**
     * Função que retorna a lista de eventos da agenda.
     * @return um <code>List</code> com a lista de Eventos armazenados na agenda.
     */
    public List<Compromisso> getListaEventos() {
        return listaEventos;
    }
    
    /**
     * Função que insere compromissos na agenda.
     * @param compromisso deve ser passado um objeto de compromisso como parâmetro.
     * @return um <code>boolean</code> identificando se foi criado/adicionado o compromisso a agenda.
     */
    public boolean create(Compromisso compromisso){
        for(Compromisso c : listaEventos){
            if((c.getDataHora().equals(compromisso.getDataHora())) && 
                    (c.getDescricao().equals(compromisso.getDescricao())) &&
                    (c.getLocal().equals(compromisso.getLocal()))) return false; 
        }
        return listaEventos.add(compromisso);
    }
    /**
     * Função que pesquisa e retorna determinados compromissos.
     * @param descricao deve ser passado a descrição do compromisso procurado
     * @return um <code>Compromisso</code> se existir ou <code>null</code> se o compromisso não existir.
     */
    public Compromisso read(String descricao){
        for(Compromisso c : listaEventos){
            if(c.getDescricao().equals(descricao))return c;
        }
        return null;
    }
    /**
     * Função que atualiza os compromissos pertinentes.
     * @param compromisso deve ser passado o compromisso com as atualizações que forem feitas
     * @param descricao deve ser passado o a descricao do compromisso que vc procura.
     * @return um <code>boolean</code> identificando se o compromisso foi ou não atualizado da lista.
     */
    public boolean update (Compromisso compromisso, String descricao){
        for(int i = 0; i < listaEventos.size(); i++){
            if(listaEventos.get(i).getDescricao().equals(descricao)){
                listaEventos.set(i, compromisso);
                return true;
            }
        }
        return false;
    }
    /**
     * Função que deleta compromissos da lista.
     * @param compromisso deve ser passado o compromisso que deve ser removido
     * @return um <code>boolean</code> identificando se o compromisso foi ou não removido.
     */
    public boolean delete(Compromisso compromisso){
        return listaEventos.remove(compromisso);
    }
    
    /**
     * Procedimento que modifica o nome da agenda.
     * @param nome deve ser passado o nome para modificação da agenda.
     */
    public void setNomeAgenda(String nome){
        this.nomeAgenda = nome;
    }
    /**
     * Função que retorna o código hash da agenda.
     * @return um <code>int</code> que identifica o hashCode da agenda.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nomeAgenda);
        hash = 67 * hash + Objects.hashCode(this.listaEventos);
        return hash;
    }
    /**
     * Função que informa se uma agenda é igual a outra ou não.
     * @param obj deve ser passado o objeto Agenda para fazer comparação.
     * @return um <code>boolean</code> identificando se as agendas são iguais ou não.
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
        final Agenda other = (Agenda) obj;
        if (!Objects.equals(this.nomeAgenda, other.nomeAgenda)) {
            return false;
        }
        if (!Objects.equals(this.listaEventos, other.listaEventos)) {
            return false;
        }
        return true;
    }
    /**
     * Função que retorna o toString de toda a agenda.
     * @return um <code>String</code> com o as características da agenda.
     */
    @Override
    public String toString() {
        return "Agenda{" + "nomeAgenda=" + nomeAgenda + ", listaEventos=" + listaEventos + '}';
    }
    
    
}
