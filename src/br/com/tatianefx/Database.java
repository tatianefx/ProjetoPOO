package br.com.tatianefx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		System.out
				.println("-------- PostgreSQL Connection Testing ------------\n");

		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "postgres";
		String url = "jdbc:postgresql://localhost:5432/products";

		try {
			Class.forName(driver);

			connection = (Connection) DriverManager.getConnection(url, user,
					senha);
			

			JOptionPane.showMessageDialog(null,
					"Conexão realizada com Sucesso!");

		} catch (ClassNotFoundException | SQLException e) {
			System.err.print(e.getMessage());
		}

	}

	public static void createTable()
	{
		try {
			stmt = connection.createStatement();

			product = "CREATE TABLE PRODUCTS" 
					+ "("
							+ "code SERIAL8 NOT NULL, "
							+ "name character(30), "
							+ "brand character(30), "
							+ "price real, "
							+ "category character(30), "
							+ "currentStock integer, "
							+ "minimumStock integer, "
							+ "maximumStock integer, "
							+ "PRIMARY KEY(code)"
					+ ");";

			stmt.execute(product);
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Tabela criada com sucesso");
	}

	public static void insertProduct(String name, String brand, float price,
			String category, int currentStock, int minimumStock,
			int maximumStock)
	{
		try {
			stmt = connection.createStatement();

			product = "INSERT INTO products (name, brand, price, category, currentStock, minimumStock, maximumStock)"
					+ "VALUES "
					+ "('" 
					+ name + "','"
					+ brand + "',"
					+ String.valueOf(price) + ",'"
					+ category + "',"
					+ String.valueOf(currentStock) + ","
					+ String.valueOf(minimumStock) + ","
					+ String.valueOf(maximumStock) 
					+ ");";

			stmt.executeUpdate(product);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto inserido com sucesso");
	}

	public static void deleteProductDatabase(int code)
	{
		try {
			stmt = connection.createStatement();
			
			connection.setAutoCommit(true);
			
			String sql = "DELETE from products WHERE code ="
					+ String.valueOf(code) + ";";
			
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto deletado");
	}

	public static void lowerStock(int code, int quantity)
	{
		try {
			stmt = connection.createStatement();

			product = "UPDATE products SET currentStock = currentStock - "
					+ String.valueOf(quantity) + " WHERE code =" + code + ";";

			stmt.executeUpdate(product);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Venda realizada");
	}

	public static void replenishStock(int code, int quantity)
	{
		try {
			stmt = connection.createStatement();

			product = "UPDATE products SET currentStock = currentStock + "
					+ String.valueOf(quantity) + " WHERE code =" + code + ";";

			stmt.executeUpdate(product);

			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Estoque atualizado");
	}

	public static Product findProduct(int code)
	{
		Product productFound = new Product();

		try {
			stmt = connection.createStatement();

			product = "SELECT * FROM products " + "WHERE code ="
					+ String.valueOf(code) + ";";

			ResultSet productFields = stmt.executeQuery(product);

			if (productFields.next()) {
				productFound.setCode(code);
				productFound.setName(productFields.getString("name"));
				productFound.setBrand(productFields.getString("brand"));
				productFound.setPrice(productFields.getFloat("price"));
				productFound.setCategory(productFields.getString("category"));
				productFound.setCurrentStock(productFields
						.getInt("currentStock"));
				productFound.setMinimumStock(productFields
						.getInt("minimumStock"));
				productFound.setMaximumStock(productFields
						.getInt("maximumStock"));
			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto encontrado");

		return productFound;
	}

	public static void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Conexão encerrada");
	}
}