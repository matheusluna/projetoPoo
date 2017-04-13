/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.excecoes;

/**
 *
 * @author Matheus Moreira Luna
 */
public class DataException extends Exception {
    /**
     * Exceção que trata as datas e horas inválidas.
     * @param msg 
     */
    public DataException(String msg){
        super(msg);
    }
    
}
