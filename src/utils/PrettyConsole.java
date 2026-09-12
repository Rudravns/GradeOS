package utils;
import java.util.List;

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

    public static <T> void show_array(List<T> array) {
        if (array.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        int i = 1;
        for (T item : array) {
            System.out.println(i + ". " + item);
            i++;
        }
    }


    public static void divider(char letter, int times){
        for (int i = 0; i<times; i++){
            System.out.print(letter);
        }
        System.out.println();
    }

    public static void divider(char letter, int times, String text){

        divider(letter, times);
        int padding = Math.max(0, (times - text.length()) / 2);
        System.out.printf("%" + (padding + text.length()) + "s%n", text);
        divider(letter, times);
    }
    /**
     * Prints a numbered list of options from any MenuOption enum.
     * Usage: PrettyConsole.showOptions(Commands.MainMenuOptions.values());
     */
    public static <T extends MenuOption> void showOptions(T[] options) {
        int i = 1;
        for (T option : options) {
            System.out.println(i + ". " + option.getDisplayName());
            i++;
        }
    }

    /**
     * Evaluates a user's input (number or text) against any MenuOption enum,
     * then calls the provided handler with the matched option.
     *
     * Usage:
     *   PrettyConsole.commandEvaluation(
     *       input,
     *       Commands.MainMenuOptions.values(),
     *       option -> executeCommand(option)
     *   );
     */
    public static <T extends MenuOption> void commandEvaluation(
            String input, T[] options, java.util.function.Consumer<T> handler) {

        input = input.trim().toLowerCase();

        if (input.equals("0") || input.equals("quit")) {
            handler.accept(options[options.length - 1]);
            return;
        }

        // Try numeric input
        try {
            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid command.");
                return;
            }
            handler.accept(options[choice - 1]);
            return;
        } catch (NumberFormatException e) {
            // Not a number, fall through to text matching
        }

        // Try text input
        for (T option : options) {
            if (option.getCommand().equals(input)) {
                handler.accept(option);
                return;
            }
        }

        System.out.println("Invalid command.");
    }

    public static void pause() {
        System.out.println();
        EasierConsole.input("Press Enter to continue...");
    }

}
