package utils;
import java.util.Scanner;

public class EasierConsole {

    static Scanner input = new Scanner(System.in); //static so everyone could use it
   
    public static String input() 
    {
        return input.nextLine();
        
    }
    
    public static String input(String text)
    {
        System.out.print(text);
        return input();
    }

    
}