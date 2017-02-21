/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpto;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class BuscaRegistros {

               public static void main(String[] args) {
                   try {
                       Class.forName("org.apache.derby.jdbc.ClientDriver");
                       String url ="jdbc:derby://localhost:1527/lpto-2017-1";
                       Connection conexao = DriverManager.getConnection(url, "usuario" , "senha");
                       System.out.println("Conexao aberta com sucesso!");
                       
                           
                            //mandar comandos após a conexão ter sido feita
                            //comando, apenas diminuir os que estiverem acima de 100
                            String sql = "SELECT nome, qtd, atualizado FROM produto";
                            Statement operacao = conexao.createStatement();
                                //executar uma ação ou uma query
                                ResultSet resultado = operacao.executeQuery(sql);
                                System.out.println("Registros encontrados!");
                                System.out.println("Nome\t\tQTD\tAtualizado");
                                
                                while(resultado.next()){
                                    System.out.print(resultado.getString("nome"));
                                    System.out.print("\t");
                                    System.out.print(resultado.getInt("qtd"));
                                    System.out.print("\t");
                                    System.out.println(resultado.getTimestamp("atualizado"));
                                }
                                
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(BuscaRegistros.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Driver não indisponível");
                            
                   } catch (SQLException ex) {
                       Logger.getLogger(BuscaRegistros.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Problema ao acessar o banco!");
                   }
    }
}


