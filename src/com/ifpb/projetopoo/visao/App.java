/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.projetopoo.visao;

import com.ifpb.projetopoo.controle.ListaUsuarios;
import com.ifpb.projetopoo.excecoes.DataException;
import com.ifpb.projetopoo.modelo.Agenda;
import com.ifpb.projetopoo.modelo.Compromisso;
import com.ifpb.projetopoo.modelo.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class App {
    public static void main(String[] args) throws DataException{
        ListaUsuarios lista = new ListaUsuarios();
        while(true){
            DateTimeFormatter formater = DateTimeFormatter.
                    ofPattern("dd/MM/uuuu").
                    withResolverStyle(ResolverStyle.STRICT);
            Scanner ler = new Scanner(System.in);
            System.out.println("BEM VINDO!");
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1: Criar usuário;");
            System.out.println("2: Fazer Login;");
            System.out.println("3: Excluir usuário;");
            System.out.println();
            System.out.print("Escolha uma opção, 0 para terminar: ");
            int opcao = ler.nextInt();
            System.out.println("=================================================");
            switch(opcao){
                case 1:
                    LocalDate dataNascimento = null;
                    System.out.print("Digite o nome:");
                    String nome = ler.next();
                    System.out.print("Digite a data de nascimento:");
                    String dataNascimentoString = ler.next();
                    try{
                        dataNascimento = LocalDate.parse(dataNascimentoString, formater);
                    }catch(DateTimeParseException e){
                        System.err.println("Data inválidas");
                        break;
                    }
                    System.out.print("Digite o seu sexo:");
                    String sexo = ler.next();
                    System.out.print("Digite o email:");
                    String email = ler.next();
                    System.out.print("Digite a senha:");
                    String senha = ler.next();
                    if(lista.create(new Usuario(nome, dataNascimento, sexo, email, senha))){
                        System.out.println("Adicionado com sucesso!");
                    }else{
                        System.out.println("Não foi possível adicionar!");
                    }
                    break;
                case 2:
                    List<Compromisso> listaCompromissosProx = new ArrayList<>();
                    System.out.print("Digite o email:");
                    email = ler.next();
                    System.out.print("Digite a senha:");
                    senha = ler.next();
                    while(lista.read(email, senha) == null){
                        System.out.println("Senha ou email inválidos:");
                        System.out.print("Digite o email:");
                        email = ler.next();
                        System.out.print("Digite a senha:");
                        senha = ler.next();
                    }
                    Usuario logado = lista.read(email, senha);
                    System.out.println("Agenda");
                    
                    while(true){
                        if(logado.getListaAgendas().size()!=0){
                            for(Agenda b: logado.getListaAgendas()){
                                System.out.println(b.getNomeAgenda());
                            }
                            
                        }
                        for(Agenda a : logado.getListaAgendas()){
                            for(int i = 0; i < a.getListaEventos().size(); i++){
                                if(a.getListaEventos().get(i).getDataHora().
                                        isAfter(LocalDateTime.now()) && 
                                        a.getListaEventos().get(i).getDataHora().
                                                isBefore(LocalDateTime.now().plusDays(30))){
                                    listaCompromissosProx.add(a.getListaEventos().get(i));
                                
                                }
                            }
                        }
                        for(Compromisso c : listaCompromissosProx){
                            System.out.println(c.toString());
                        }
                        System.out.println("1: criar agenda;");
                        System.out.println("2: criar compromisso;");
                        System.out.println("3: Sair;");
                        System.out.println();
                        System.out.print("Digite uma opção");
                        opcao = ler.nextInt();
                        if(opcao == 3) break;
                        switch(opcao){
                            case 1:
                                System.out.print("Digite o nome da agenda: ");
                                String nomeAgenda = ler.next();
                                
                                if(logado.create(nomeAgenda)){
                                    System.out.println("Criado com sucesso");
                                }
                                break;
                            case 2:
                                System.out.print("Digite a data: ");
                                String dataString = ler.next();
                                LocalDate data = LocalDate.parse(dataString, formater);
                                System.out.print("Digite a hora: ");
                                String horaString = ler.next();
                                LocalTime hora = LocalTime.parse(horaString, DateTimeFormatter.ISO_LOCAL_TIME);
                                LocalDateTime dataHora = LocalDateTime.of(data, hora);
                                System.out.print("Digite a descrição: ");
                                String descricao = ler.next();
                                System.out.print("Digite Local: ");
                                String local = ler.next();
                                System.out.print("Digite a agenda: ");
                                String agenda = ler.next();
                                if(logado.update(new Compromisso(dataHora, descricao, local), agenda)){
                                    System.out.println("Cadastrado com sucesso");
                                }else{
                                    System.out.println("Não foi possível cadastrar");
                                }
                                break;
                        }
                    }
            }   
        }
    }
}
