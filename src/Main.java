import java.util.ArrayList; // Import the ArrayList class//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import utils.PrettyConsole; //import the utils

static ArrayList<Student> all_students = new ArrayList<Student>();

enum Option {
    ADD_STUDENT("Add Student"),
    VIEW_STUDENTS("View Students"),
    REMOVE_STUDENT("Remove Student"),
    EXIT("Exit");

    private final String displayName;

    Option(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

void main() {
    //entry point
    PrettyConsole.divider( '=', 50, "Welcome to grade OS");
    System.out.println();

    PrettyConsole.show_array(all_students);
    PrettyConsole.divider('=',50);
    showOptions();

}

void showOptions() {
    System.out.println();
    int number = 1;
    for (Option option : Option.values()) {
        System.out.println(number + ". " + option.getDisplayName());
        number++;
    }
}

