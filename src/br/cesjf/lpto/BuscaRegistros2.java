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
public class BuscaRegistros2 {

               public static void main(String[] args) {
                   try {
                       Class.forName("org.apache.derby.jdbc.ClientDriver");
                       String url ="jdbc:derby://localhost:1527/lpto-2017-1";
                       Connection conexao = DriverManager.getConnection(url, "usuario" , "senha");
                       System.out.println("Conexao aberta com sucesso!");
                       
                           
                            //mandar comandos após a conexão ter sido feita
                            //comando, apenas diminuir os que estiverem acima de 100
                            //calculando qual são menores que 200 para comprar
                            String sql = "SELECT nome, 200-qtd FROM produto"
                                    + "WHERE qtd<200";
                            Statement operacao = conexao.createStatement();
                                //executar uma ação ou uma query
                                ResultSet resultado = operacao.executeQuery(sql);
                                System.out.println("Registros encontrados!");
                                System.out.println("Nome\t\tAComprar");
                                
                                while(resultado.next()){
                                    System.out.print(resultado.getString(1));
                                    System.out.print("\t");
                                    System.out.print(resultado.getInt(2));
                                    System.out.println("\t");
                                  
                                }
                                
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(BuscaRegistros2.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Driver não indisponível");
                            
                   } catch (SQLException ex) {
                       Logger.getLogger(BuscaRegistros2.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Problema ao acessar o banco!");
                   }
    }
}


