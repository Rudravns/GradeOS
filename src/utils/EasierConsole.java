package utils;

public class EasierConsole {

    public static void divider(char character, int length, String title) {
        // Print a divider line with a title
        System.out.println(title);
        for (int i = 0; i < length; i++) {
            System.out.print(character);
        }
        System.out.println();
    }
}