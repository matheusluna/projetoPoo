/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.modelo;
import com.ifpb.projetopoo.excecoes.DataException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Matheus Moreira Luna
 */
public class Compromisso {
    private LocalDateTime dataHora;
    private String  descricao;
    private String local;

    public Compromisso() {
    }
    /**
     * 
     * @param dataHora deve ser passado um <code>LocaldateTime</code> pada identificar a hora e data do compromisso.
     * @param descricao deve ser passado um <code>String</code> pada identificar a descrição do que se trata o compromisso.
     * @param local deve ser passado um <code>Local</code> pada identificar o local do compromisso.
     * @throws DataException Se hover esta exceção, é porque a data e hora do evento já passou.
     */
    public Compromisso(LocalDateTime dataHora, String descricao, String local) throws DataException {
        if(dataHora.isBefore(LocalDateTime.now())) 
            throw new DataException("Esta data já passou");
        
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.local = local;
    }
    /**
     * Função que retorna a data e hora do evento.
     * @return um <code>LocaldateTime</code> como parâmetro de identificação da data e hora.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    /**
     * Procedimento que modifica a data e hora do compromisso.
     * @param dataHora deve ser passado um <code>LocaldateTime</code> com data e hora para modificação.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Função que retorna a descrição do compromisso.
     * @return um <code>String</code> com a descrição do compromisso.
     */

    public String getDescricao() {
        return descricao;
    }
    /**
     * Procedimento que modifica a descrição do compromisso.
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /**
     * Função que retorna o local do compromisso.
     * @return um <code>String</code> como parâmetro.
     */
    public String getLocal() {
        return local;
    }
    /**
     * Procedimento que modifica o local do compromisso
     * @param local deve ser passado um <code>String</code> infomando o lical novo.
     */
    public void setLocal(String local) {
        this.local = local;
    }
    /**
     * Função que retorna o hashCode do compromisso.
     * @return um <code>int</code> que identifica o hashCode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.dataHora);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.local);
        return hash;
    }
    /**
     * Função onde se passa outro compromisso para comparar e retornar se são iguais ou não.
     * @param obj deve ser passado um <code>obj</code> com o compromisso de comparação.
     * @return um <code>boolean</code> identificando se são iguais ou não.
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
        final Compromisso other = (Compromisso) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        return true;
    }
    /**
     * Função que retorna o toString do compromisso.
     * @return um <code>String</code> com as caracteristicas do compromisso.
     */
    @Override
    public String toString() {
        return "Compromisso{" + "dataHora=" + dataHora + ", descricao=" + descricao + ", local=" + local + '}';
    }

    
    
    
    
}
