package br.com.bingo.funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeradorDeTabelas {
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://financ.c2xez8trp1lt.sa-east-1.rds.amazonaws.com:3306/";
    private String userPass = "?user=root&password=";
    private String dbName = "bingo";
    private String userName = "admin";
    private String password = "banana2012";

    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet result;
    private Connection con;
    
    private String texto;
    
    public void createTableCub1(String nometabela, String[] nomes,  String[] tipos) {
        String myTableName = "CREATE TABLE " + nometabela + " ( " ;
            
       
        
       for(int i =0; i<0;i++) { 
    	 String contexto = nomes[i] + " " + tipos[i]+ " , " ;
    	 
    	 this.texto = contexto;
       }
       
       String finaltabela =  "     PRIMARY KEY("+nomes[0]+"))     ";
       
       String MinhaTabela = myTableName + this.texto  /*finaltabela*/;
        
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //This line has the issue
            statement.executeUpdate(MinhaTabela);
            System.out.println("Table Created");
        }
        catch (SQLException e ) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
    }	

}
