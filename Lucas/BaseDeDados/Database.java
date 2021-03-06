package BaseDeDados;

import Principal.Main;

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

  public static void connectDatabase(String senha,String user)
  {
    System.out
        .println("-------- PostgreSQL Connection Testing ------------\n");

    String driver = "org.postgresql.Driver";
    //String user = "postgres";
    //String senha = "admin";
    String url = "jdbc:postgresql://localhost:5432/products";

    try {
      Class.forName(driver);

      connection = (Connection) DriverManager.getConnection(url, user,senha);

      JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!");
      Main.fechaJanelaConexao();
      Main.criaJanelaPrincipal();

    } catch (ClassNotFoundException | SQLException e) {
      System.err.print(e.getMessage());
      JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido");
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

  public static boolean productExists(String name, String brand){
    try {
      stmt = connection.createStatement();

      ResultSet result = stmt.executeQuery( "SELECT * FROM products;" );

      while ( result.next() )
      {

        String  nameProduct = result.getString("name");
        String  brandProduct = result.getString("brand");

        if ( (nameProduct.trim()).equalsIgnoreCase(name.trim()) && (brandProduct.trim()).equalsIgnoreCase(brand.trim()) )
        {
          JOptionPane.showMessageDialog(null, "Produto já está cadastrado!");
          return true;
        }
      }
      result.close();
      stmt.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    return false;
  }

  public static void insertProduct(String name, String brand, float price,
                                   String category, int currentStock,
                                   int minimumStock, int maximumStock)
  {
    if(!productExists(name, brand)) {
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
      } catch(Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
      }
      JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
    }
    else {
      //TODO tratar caso produto ja existe
      //Ideia: oferecer para trocar as informações do produto pelas informadas
    }
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

  public static void showAllProducts()
  {
    try{
      stmt = connection.createStatement();

      ResultSet result = stmt.executeQuery( "SELECT * FROM products;" );

      while ( result.next() ) {
        int code = result.getInt("code");
        String  name = result.getString("name");
        String  brand = result.getString("brand");
        float price = result.getFloat("price");
        String  category = result.getString("category");
        int currentStock  = result.getInt("currentStock");

        System.out.println( "Código.......: " + code );
        System.out.println( "Nome.........: " + name );
        System.out.println( "Marca........: " + brand );
        System.out.println( "Preço........: " + price );
        System.out.println( "Categoria....: " + category );
        System.out.println( "Estoque......: " + currentStock );

        System.out.println();
      }

      result.close();
      stmt.close();

    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

    System.out.println("Fim da lista de produtos.");
  }

  public static void shoppingList()
  {
    try {
      stmt = connection.createStatement();

      ResultSet result = stmt.executeQuery( "SELECT * FROM products;" );

      while ( result.next() )
      {
        int code = result.getInt("code");
        String  name = result.getString("name");
        String  brand = result.getString("brand");
        String  category = result.getString("category");
        int currentStock  = result.getInt("currentStock");
        int minimumStock = result.getInt("minimumStock");
        int maximumStock = result.getInt("maximumStock");

        if(currentStock < minimumStock)
        {
          System.out.println( "Código..........: " + code );
          System.out.println( "Nome............: " + name );
          System.out.println( "Marca...........: " + brand );
          System.out.println( "Categoria.......: " + category );
          System.out.println( "Quantidade......: " + (maximumStock - currentStock) );

          System.out.println();
        }
      }

      result.close();
      stmt.close();

    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

    System.out.println("Fim da lista de compras");
  }

  public static void alterProductData(int code, String column, String newValue)
  {
    try {
      stmt = connection.createStatement();

      product = "UPDATE products SET " + column + " = '" +
          newValue + "' WHERE code =" + code + ";";

      stmt.executeUpdate(product);
      stmt.close();

    } catch (Exception e) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

    System.out.println("Alteração realizada");
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
