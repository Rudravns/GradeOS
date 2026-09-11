package utils;
import java.util.ArrayList;

public class pretty_console {
    static void blink_text(String text, long wait, boolean not_next_line) {

        for (char l : text.toCharArray()) {
            System.out.print(l);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }


    }

    static void blink_text(String text, long wait) {

        for (char l : text.toCharArray()) {
            System.out.print(l);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println();
    }

    static void blink_text(String text) {

        for (char l : text.toCharArray()) {
            System.out.print(l);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println();
    }

    static <T> void show_array(ArrayList<T> array) {
        if (array.isEmpty()){blink_text("There are no students added, please add a new student to continue");}

        int i = 1;
        for (T item : array) {
            System.out.println(Integer.toString(i)+". "+  item);
            i++;
        }
    }

    static void divider(String text, char letter, int times){
        for (int i = 0; i<times; i++){
            System.out.print(letter);
        }

        int middle = (int)(times/2 - text.length()/2);
        for (int i = 0; i<times; i++){
            System.out.print(" ");
        }

        blink_text(text);

        for (int i = 0; i<times; i++){
            System.out.print(letter);
        }
    }

    static void divider(char letter, int times){
        for (int i = 0; i<times; i++){
            System.out.print(letter);
        }
    }

}
