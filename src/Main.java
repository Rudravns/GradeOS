import java.util.ArrayList; // Import the ArrayList class
import utils.*; //import the utils

static ArrayList<Student> all_students = new ArrayList<Student>();

enum MainMenuOptions {
    ADD_STUDENT("Add Student", "add student"),
    VIEW_STUDENTS("View Students", "view students"),
    REMOVE_STUDENTS("Remove Students", "remove students"),
    EXIT("Exit", "exit");

    private final String displayName;
    private final String command;

    MainMenuOptions(String displayName, String command) {
        this.displayName = displayName;
        this.command = command;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCommand() {
        return command;
    }
}

void main() {
    //entry point
    PrettyConsole.divider( '=', 50, "Welcome to grade OS");
    System.out.println();

    PrettyConsole.show_array(all_students);
    PrettyConsole.divider('=',50);
    showOptions();
    
    System.out.println();
    PrettyConsole.divider('=',50);

    String user = EasierConsole.input("Enter command number or name")

}

void showOptions() {
    System.out.println();
    int number = 1;
    for (MainMenuOption option : MainMenuOption.values()) {
        System.out.println(number + ". " + option.getDisplayName());
        number++;
    }
}

void commandEvaluation(String input) {

    input = input.trim().toLowerCase();

    // Try number first
    try {
        int choice = Integer.parseInt(input);

        Option selected = Option.values()[choice - 1];
        executeCommand(selected);

        return;

    } catch (NumberFormatException e) {
        // Not a number, so try text
    }

    // Try text command
    for (Option option : Option.values()) {
        if (option.getCommand().equals(input)) {
            executeCommand(option);
            return;
        }
    }

    System.out.println("Invalid command.");
}