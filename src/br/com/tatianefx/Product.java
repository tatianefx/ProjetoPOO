
package br.com.tatianefx;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tatianefx.utils.Read;

public class Product
{
	private String name;
	private int code;
	private String brand;
	private float price;
	private String category;
	private int currentStock;
	private int minimumStock;
	private int maximumStock;
	
	public Product() {
	}
	
	public Product(ResultSet resultSet) throws SQLException{
		code = resultSet.getInt("code");
		name = resultSet.getString("name");
		brand = resultSet.getString("brand");
		price = resultSet.getFloat("price");
		category = resultSet.getString("category");
		currentStock = resultSet.getInt("currentStock");
		minimumStock = resultSet.getInt("minimumStock");
		maximumStock = resultSet.getInt("maximumStock");
	}
		
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
	
	public void productSale(int code, int quantity)
	{		
		Database.lowerStock(code, quantity);
	}
	
	public void deleteProduct()
	{	
		Database.deleteProductDatabase( Read.readInt("Codigo:") );
	}
	
	public void changeTheProductName()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "name", Read.readString("Novo nome:") );
	}
	
	public void changeTheProductBrand()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "brand", Read.readString("Nova marca:") );
	}
	
	public void changeTheProductPrice()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "price", Read.readString("Novo preco:") );
	}
	
	public void changeTheProductCategory()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "category", Read.readString("Nova categoria:") );
	}
	
	public void changeTheProductCurrentStock()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "currentStock", Read.readString("Novo valor de estoque atual:") );
	}
	
	public void changeTheProductMinimumStock()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "minimumStock", Read.readString("Novo valor de estoque minimo:") );
	}
	
	public void changeTheProductMaximumStock()
	{
		Database.alterProductData( Read.readInt("Codigo:"), "maximumStock", Read.readString("Novo valor de estoque maximo:") );
	}
	
	public void showProduct()
	{
		System.out.println( "Código.......: " + getCode() );
		System.out.println( "Nome.........: " + getName() );
		System.out.println( "Marca........: " + getBrand() );
		System.out.println( "Preço........: " + getPrice() );
		System.out.println( "Categoria....: " + getCategory() );
		System.out.println( "Estoque......: " + getCurrentStock() );
	}
}