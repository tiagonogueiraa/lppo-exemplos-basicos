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
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ListaRegistros2 {

               public static void main(String[] args) {
                   try {
                       Class.forName("org.apache.derby.jdbc.ClientDriver");
                       String url ="jdbc:derby://localhost:1527/lpto-2017-1";
                       Connection conexao = DriverManager.getConnection(url, "usuario" , "senha");
                       System.out.println("Conexao aberta com sucesso!");
                       
                           
                            //mandar comandos após a conexão ter sido feita
                            //comando, apenas diminuir os que estiverem acima de 100
                            String sql = "select nome, (200-qtd) as quantidade from produto where qtd<200";
                            Statement operacao = conexao.createStatement();
                                //executar uma ação ou uma query
                                ResultSet resultado = operacao.executeQuery(sql);
                                System.out.print("Nome\t\t\tA Comprar\tAtualizado");
                                while(resultado.next())
                                {
                                    System.out.print("\n"+resultado.getString("nome"));
                                    System.out.print("\t\t"+resultado.getInt("quantidade"));
                                    //System.out.print("\t"+resultado.getTimestamp("atualizado"));
                                }
                       
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(AtualizaRegistros.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Driver não indisponível");
                            
                   } catch (SQLException ex) {
                       Logger.getLogger(AtualizaRegistros.class.getName()).log(Level.SEVERE, null, ex);
                            System.err.println("Problema ao acessar o banco!");
                   }
    }
}


