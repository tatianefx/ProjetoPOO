
package br.com.tatianefx;

import br.com.tatianefx.utils.Read;

public class Main 
{

	public static void main(String[] args)
	{
		Database.connectDatabase();
		//Database.createTable();									/*Testar se a tabela já existe*/
		
		Products product1 = new Products();							/*Teste insere produto*/
		product1.registerProduct();
		
		Products product2;											/*Teste busca produto*/
		product2 = Database.findProduct(Read.readInt("Codigo:")); 	/*Retorna um produto*/
		product2.productSale(Read.readInt("Quantidade:"));			/*Teste venda de produto*/
		
		//Products product3;										/*Teste busca produto*/
		//product3 = Database.findProduct(Read.readInt("Codigo:")); /*Retorna um produto*/
		//product3.deleteProduct();									/*Teste deleta produto*/	
		
		Database.closeConnection();
	}
}