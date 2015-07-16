package br.com.tatianefx.utils;

import java.util.Scanner;

public abstract class Read
{
	private static Scanner scanner = new Scanner(System.in);
	
	public static String readString(String message)
	{
		System.out.println(message);
		return scanner.nextLine();
	}
	
	public static float readFloat(String message)
	{
		float numberFloat;
		
		System.out.println(message);
		
		numberFloat = scanner.nextFloat();
		scanner.nextLine();
		
		return numberFloat;
	}
	
	public static int readInt(String message)
	{
		int numberInt;
		
		System.out.println(message);
		
		numberInt = scanner.nextInt();
		scanner.nextLine();
		
		return numberInt;
	}
}
