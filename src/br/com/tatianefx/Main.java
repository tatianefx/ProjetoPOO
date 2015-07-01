
package br.com.tatianefx;

import br.com.tatianefx.utils.Read;

public class Main 
{

	public static void main(String[] args)
	{
		Database.connectDatabase();
		//Database.createTable();									/*Testar se a tabela já existe*/
		
		Product product1 = new Product();							/*Teste insere produto*/
		product1.registerProduct();
		
		Product product2;											/*Teste busca produto*/
		product2 = Database.findProduct(Read.readInt("Codigo:")); 	/*Retorna um produto*/
		product2.productSale(Read.readInt("Quantidade:"));			/*Teste venda de produto*/
		
		//Products product3;										/*Teste busca produto*/
		//product3 = Database.findProduct(Read.readInt("Codigo:")); /*Retorna um produto*/
		//product3.deleteProduct();									/*Teste deleta produto*/	
		
		Database.closeConnection();
	}
}