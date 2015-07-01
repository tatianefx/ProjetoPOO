
package br.com.tatianefx;

import br.com.tatianefx.utils.Read;

public class Products
{
	private String name;
	private int code;
	private String brand;
	private float price;
	private String category;
	private int currentStock;
	private int minimumStock;
	private int maximumStock;
		
	public String getName()
	{
		return name;
	}
	
	public boolean setName(String name)
	{
		if (name.length() > 0)
		{
			this.name = name;
			return true;
		}
		else
		{
			System.out.println("Nome inválido!");
			return false;
		}	
	}
	
	public int getCode()
	{
		return code;
	}
	
	public void setCode(int code)
	{
		this.code = code;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public boolean setBrand(String brand)
	{
		if (brand.length() > 0)
		{
			this.brand = brand;
			return true;
		}
		else
		{
			System.out.println("Marca inválida!");
			return false;
		}	
	}
	
	
	public float getPrice()
	{
		return price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public boolean setCategory(String category)
	{
		if (category.length() > 0)
		{
			this.category = category;
			return true;
		}
		else
		{
			System.out.println("Tipo inválido!");
			return false;
		}
		
		
	}
	
	public int getCurrentStock()
	{
		return currentStock;
	}
	
	public void setCurrentStock(int currentStock)
	{
		this.currentStock = currentStock;
	}
	
	public int getMinimumStock()
	{
		return minimumStock;
	}
	
	public void setMinimumStock(int minimumStock)
	{
		this.minimumStock = minimumStock;
	}
	
	public int getMaximumStock()
	{
		return maximumStock;
	}
	
	public void setMaximumStock(int maximumStock)
	{
		this.maximumStock = maximumStock;
	}
	
	public void registerProduct()
	{	
		while( !setName( Read.readString( "Nome:" ) ) );
		
		while( !setBrand( Read.readString( "Marca:" ) ) );
		
		while( !setCategory( Read.readString( "Categoria:" ) ) );
		
		setPrice( Read.readFloat("Preço:") );
		
		setCurrentStock( Read.readInt("Estoque Atual:") );
		
		setMinimumStock( Read.readInt("Minimo no estoque:") );
		
		setMaximumStock( Read.readInt("Maximo no estoque:") );
		
		Database.insertProduct(name, brand, price, category, currentStock, minimumStock, maximumStock);
		
	}
	
	public void productSale(int quantity)
	{		
		Database.lowerStock(this.code, quantity);
	}
	
	public void deleteProduct()
	{		
		Database.deleteProductDatabase(getCode());
	}
}