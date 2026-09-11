package utils;
import java.util.ArrayList;

public class PrettyConsole {
    public static void blinkText(String text, long wait, boolean notNextLine) {

        for (char letter : text.toCharArray()) {
            System.out.print(letter);

            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (!notNextLine) {
            System.out.println();
        }
    }

    public static void blinkText(String text, long wait) {
        blinkText(text, wait, false);
    }

    public static void blinkText(String text) {
        blinkText(text, 50, false);
    }

    public static <T> void show_array(ArrayList<T> array) {
        if (array.isEmpty() ){blinkText("There are no students added, please add a new student to continue");  System.out.println(); return;}

        int i = 1;
        for (T item : array) {
            System.out.println(Integer.toString(i)+". "+  item);
            i++;
        }
    }


    public static void divider(char letter, int times){
        for (int i = 0; i<times; i++){
            System.out.print(letter);
        }

    }

    public static void divider(char letter, int times, String text){

        divider(letter , times);

        System.out.println();
        int middle = (int)(times/2 - text.length()/2);
        for (int i = 0; i<middle; i++){
            System.out.print(" ");
        }

        blinkText(text);

        divider(letter , times);
        System.out.println();
    }


    public static void clearConsole() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush();
    }

}
