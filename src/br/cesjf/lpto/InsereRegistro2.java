/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpto;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class InsereRegistro2 {

               public static void main(String[] args) {
                   try {
                       Class.forName("org.apache.derby.jdbc.ClientDriver");
                       String url ="jdbc:derby://localhost:1527/lpto-2017-1";
                       Connection conexao = DriverManager.getConnection(url, "usuario" , "senha");
                       System.out.println("Conexao aberta com sucesso!");
                       
                        Random rnd = new Random();
                     
                            //mandar comandos após a conexão ter sido feita
                            String sql = "INSERT INTO produto(nome, qtd) VALUES ('Produto "
                                    + rnd.nextInt(50)+ "',"
                                    + rnd.nextInt(200)+ ")";
                            Statement operacao = conexao.createStatement();
                                //executar uma ação ou uma query
                                operacao.executeUpdate(sql);
                                System.out.println(""
                                        + "Registro inserido!");
                       
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(InsereRegistro2.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Driver não indisponível");
                            
                   } catch (SQLException ex) {
                       Logger.getLogger(InsereRegistro2.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Problema ao acessar o banco!");
                   }
    }
}


