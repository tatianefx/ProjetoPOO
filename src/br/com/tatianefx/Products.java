
package br.com.tatianefx;

import br.com.tatianefx.utils.Read;

public class Products
{
	private String nome;
	private String marca;
	private float preco;
	private String tipo;
	private int quantidadeTotal;
	private int quantidadeMinima;
	private int quantidadeMaxima;
		
	public String getNome()
	{
		return nome;
	}
	
	public boolean setNome(String nome)
	{
		if (nome.length() > 0)
		{
			this.nome = nome;
			return true;
		}
		else
		{
			System.out.println("Nome inválido!");
			return false;
		}	
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	public boolean setMarca(String marca)
	{
		if (marca.length() > 0)
		{
			this.marca = marca;
			return true;
		}
		else
		{
			System.out.println("Marca inválida!");
			return false;
		}	
	}
	
	
	public float getPreco()
	{
		return preco;
	}
	
	public void setPreco(float preco)
	{
		this.preco = preco;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public boolean setTipo(String tipo)
	{
		if (tipo.length() > 0)
		{
			this.tipo = tipo;
			return true;
		}
		else
		{
			System.out.println("Tipo inválido!");
			return false;
		}
		
		
	}
	
	public int getQuantidadeTotal()
	{
		return quantidadeTotal;
	}
	
	public void setQuantidadeTotal(int quantidadeTotal)
	{
		this.quantidadeTotal = quantidadeTotal;
	}
	
	public int getQuantidadeMinima()
	{
		return quantidadeMinima;
	}
	
	public void setQuantidadeMinima(int quantidadeMinima)
	{
		this.quantidadeMinima = quantidadeMinima;
	}
	
	public int getQuantidadeMaxima()
	{
		return quantidadeMaxima;
	}
	
	public void setQuantidadeMaxima(int quantidadeMaxima)
	{
		this.quantidadeMaxima = quantidadeMaxima;
	}
	
	public void readData()
	{	
		while( !setNome( Read.readString( "Nome:" ) ) );
		
		while( !setMarca( Read.readString( "Marca:" ) ) );
		
		while( !setTipo( Read.readString( "Categoria:" ) ) );
		
		setPreco( Read.readFloat("Preço:") );
		
		setQuantidadeTotal( Read.readInt("Quantidade Total:") );
		
		setQuantidadeMinima( Read.readInt("Quantidade Minima:") );
		
		setQuantidadeMaxima( Read.readInt("Quantidade Máxima:") );
		
	}
}
