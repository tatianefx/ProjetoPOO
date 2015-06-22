
package br.com.tatianefx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public abstract class Database
{
	static Connection connection = null;
    static Statement stmt = null;
    static String product;
	
    public static void connectDatabase()
    {
    	System.out.println("-------- PostgreSQL Connection Testing ------------\n");
   	 
        String driver = "org.postgresql.Driver";  
        String user = "postgres";  
        String senha = "postgres";  
        String url = "jdbc:postgresql://localhost:5432/produtos";
        
        try
        {  
            Class.forName(driver);    

            connection = (Connection) DriverManager.getConnection(url, user, senha);  

            JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!");  

        }
        catch (ClassNotFoundException | SQLException e)
        {  
            System.err.print(e.getMessage());  
        }
        
    }
    
    public static void createTable()
    {
    	try
    	{
    	stmt = connection.createStatement();
    	
        product = "CREATE TABLE produtos"+
        		  "("+
        		  		"codigo SERIAL8 NOT NULL,"+
        		  		"nome character(30),"+
        		  		"marca character(30),"+
        				"preco real,"+
        				"tipo character(30),"+
        				"quantidade integer,"+
        				"quantidade_minima integer,"+
        				"quantidade_maxima integer,"+
        				"PRIMARY KEY(codigo)"+
        		  ");";
                 
        stmt.executeUpdate(product);
        
        stmt.close();
        connection.close();
		
		}
    	catch (Exception e)
    	{
		System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
    	}
    	
    	System.out.println("Table created successfully");
    }
	
    public static void registerProducts(String nome, String marca, float preco, String tipo, int quantidadeTotal, int quantidadeMinima, int quantidadeMaxima)
    {
    	try
        {
        	stmt = connection.createStatement();

        	product = "INSERT INTO PRODUTOS (nome, marca, preco, tipo, quantidade, quantidade_minima, quantidade_maxima)"
        			+ "VALUES ('"+ nome + "','" +
        			marca + "'," +
        			String.valueOf(preco) + ",'" + 
        			tipo + "'," +
        			String.valueOf(quantidadeTotal) + "," + 
        			String.valueOf(quantidadeMinima) + "," +
        			String.valueOf(quantidadeMaxima) +
        			");";

        	stmt.executeUpdate(product);

        	stmt.close();
        	connection.close();

        }
    	catch (Exception e)
    	{
    		System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    		System.exit(0);
    	}

    	System.out.println("Insert product successfully");
    }
}
