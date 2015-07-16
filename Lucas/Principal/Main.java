
package Principal;

import Interface.JanelaConexao;
import Interface.JanelaInicio;
import Interface.JanelaNovoProduto;
import Interface.JanelaPrincipal;

public class Main {

  static JanelaPrincipal principal;
  static JanelaConexao janelaConexao;
  static JanelaNovoProduto janelaNovoProduto;

  public static void criaJanelaPrincipal(){
    principal = new JanelaPrincipal();
  }
  public static void criaJanelaConexao(){
    janelaConexao = new JanelaConexao();
  }
  public static void fechaJanelaPrincipal(){
    principal.dispose();
  }
  public static void fechaJanelaConexao(){
    janelaConexao.dispose();
  }
  public static void criaJanelaNovoProduto(){
    janelaNovoProduto = new JanelaNovoProduto();
  }
  public static void fechaJanelaNovoProduto(){
    janelaNovoProduto.dispose();
  }
  //public static
  public static void main(String[] args)
  {
    JanelaInicio janela = new JanelaInicio();


    //Database.connectDatabase();
    //Database.createTable();									/*Testar se a tabela já existe*/

    //Product product1 = new Product();							/*Teste insere produto*/
    //product1.registerProduct();

    //Product product2;											/*Teste busca produto*/
    //product2 = Database.findProduct(Read.readInt("Codigo:")); 	/*Retorna um produto*/
    //product2.productSale(Read.readInt("Quantidade:"));			/*Teste venda de produto*/

    //Products product3;										/*Teste busca produto*/
    //product3 = Database.findProduct(Read.readInt("Codigo:")); /*Retorna um produto*/
    //product3.deleteProduct();									/*Teste deleta produto*/

    //Database.closeConnection();
  }
}
