
package br.com.tatianefx;

public class Main 
{

	public static void main(String[] args)
	{
		Database.connectDatabase();
		//Database.createTable();									/*Testar se a tabela já existe*/
		
		//Database.shoppingList();
		
		//Product product1 = new Product();							
		//product1.changeTheProductName();							/*testa mudança de nome do produto*/
		//product1.changeTheProductPrice();							/*testa mudança de preço do produto*/
		
/*		int tam  = 5;
		Product product1;
		
		while (tam != 0) 
		{
			product1 = new Product();							   //Teste insere produto
			product1.registerProduct();
			
			tam--;
		}
		
		Database.showAllProducts();
*/		
		//Product product2;											/*Teste busca produto*/
		//product2 = Database.findProduct(Read.readInt("Codigo:")); 	/*Retorna um produto*/
		
		//product2.showProduct();
		
		//Product product2 = new Product();
		//product2.productSale(Read.readInt("Codigo:"), Read.readInt("Quantidade:"));	/*Teste venda de produto*/
		
		//Products product3;										/*Teste busca produto*/
		//product3 = Database.findProduct(Read.readInt("Codigo:")); /*Retorna um produto*/
		//product3.deleteProduct();									/*Teste deleta produto*/	
		
		Database.closeConnection();
	}
}