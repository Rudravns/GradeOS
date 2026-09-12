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
        PrettyConsole.blinkText(text, 50, true);
        return input();
    }

    public static int inputInt(String text)
    {
        PrettyConsole.blinkText(text, 0, true);
        while (true) {
            try {
                return Integer.parseInt(input());
            } catch (NumberFormatException e) {
                PrettyConsole.blinkText("Invalid input. Please enter a valid integer: ", 0, true);
            }
        }
    }

    public static int inputIntInRange(String text, int minimum, int maximum)
    {
        while (true) {
            int value = inputInt(text);
            if (value >= minimum && value <= maximum) return value;
            PrettyConsole.blinkText("Enter a number from " + minimum + " to " + maximum + ".", 0, false);
        }
    }

    public static double inputDouble(String text)
    {
        PrettyConsole.blinkText(text, 0, true);
        while (true) {
            try {
                return Double.parseDouble(input());
            } catch (NumberFormatException e) {
                PrettyConsole.blinkText("Invalid input. Please enter a valid number: ", 0, true);
            }
        }
    }

    public static double inputDoubleInRange(String text, double minimum, double maximum)
    {
        while (true) {
            double value = inputDouble(text);
            if (value >= minimum && value <= maximum) return value;
            PrettyConsole.blinkText(String.format("Enter a number from %.2f to %.2f.", minimum, maximum));
        }
    }

    
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle exception or fallback to printing newlines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

}