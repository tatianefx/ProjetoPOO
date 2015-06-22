
package br.com.tatianefx;

public class Main 
{

	public static void main(String[] args)
	{
		Database.connectDatabase();
		
		Products products = new Products();
		products.readData();
		
		Database.registerProducts(products.getNome(), products.getMarca(), products.getPreco(), products.getTipo(), products.getQuantidadeTotal(), products.getQuantidadeMinima(), products.getQuantidadeMaxima());
	
	}

}
