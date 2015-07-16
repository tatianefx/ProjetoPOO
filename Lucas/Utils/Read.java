package Utils;

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
    System.out.println(message);
    return scanner.nextFloat();
  }

  public static int readInt(String message)
  {
    System.out.println(message);
    return scanner.nextInt();
  }
}
