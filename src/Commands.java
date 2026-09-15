import utils.*;
public class Commands {

    public enum MainMenuOptions implements utils.MenuOption { 
        VIEW_STUDENTS("View Students", "view students"),
        SAVE_STUDENTS("Save Students", "save students"),
        LOAD_STUDENTS("Load Students", "load students"),
        EXIT("Exit", "exit");

        private final String displayName;
        private final String command;

        MainMenuOptions(String displayName, String command) { // Constructor for the enum, goes through each enum value and assigns the display name and command
            this.displayName = displayName;
            this.command = command;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getCommand() {
            return command;
        }
    }

    public enum StudentsMenuOptions implements utils.MenuOption {
        OPEN_GRADEBOOK("Open Gradebook", "open gradebook"),
        ADD_STUDENT("Add Student", "add student"),
        REMOVE_STUDENTS("Remove Students", "remove students"),
        EXIT("Exit", "exit");

        private final String displayName;
        private final String command;

        StudentsMenuOptions(String displayName, String command) { // Constructor for the enum, goes through each enum value and assigns the display name and command
            this.displayName = displayName;
            this.command = command;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getCommand() {
            return command;
        }
    }

    public enum GradebookMenuOptions implements utils.MenuOption{
        MANAGE_SUBJECTS("Manage Subjects", "manage subjects"),
        EXIT("Back to Students", "back");

        private final String displayName;
        private final String command;

        GradebookMenuOptions(String displayName, String command) {
            this.displayName = displayName;
            this.command = command;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getCommand() {
            return command;
        }
    }

    public enum SubjectsMenuOptions implements utils.MenuOption {
        ADD_SUBJECT("Add Subject", "add subject"),
        REMOVE_SUBJECT("Remove Subject", "remove subject"),
        OPEN_SUBJECT("Open Subject Grades", "open subject grades"),
        EXIT("Back to Gradebook", "back");

        private final String displayName;
        private final String command;

        SubjectsMenuOptions(String displayName, String command) {
            this.displayName = displayName;
            this.command = command;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getCommand() {
            return command;
        }
    }

    public enum GradesMenuOptions implements utils.MenuOption {
        ADD_GRADE("Add Grade", "add grade"),
        REMOVE_GRADE("Remove Grade", "remove grade"),
        EXIT("Back to Subjects", "back");

        private final String displayName;
        private final String command;

        GradesMenuOptions(String displayName, String command) {
            this.displayName = displayName;
            this.command = command;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public String getCommand() {
            return command;
        }
    }

    public static Student addStudent() {
        EasierConsole.clearConsole();
        PrettyConsole.divider('=', 50, "Add Student");

        String name = EasierConsole.input("Enter student name (ex: Rudransh): ");
        int year = EasierConsole.inputIntInRange("Enter student grade (1-12): ", 1, 12);

        return new Student(name, year);
    }

    public static Subject addSubject() {
        String name = EasierConsole.input("Enter subject name: ");
        String level = EasierConsole.input("Is this an AP or Honors subject? (y/n): ");
        return new Subject(name, level.trim().equalsIgnoreCase("y"));
    }

    public static Grade addGrade() {
        String name = EasierConsole.input("Enter grade name (ex: Chapter 1 Quiz): ");
        double[] score = inputScore();
        double weightage = EasierConsole.inputDoubleInRange("Enter grade weightage (0-100%): ", 0.01, 100);
        String tag = EasierConsole.input("Enter tag (optional, ex: test, quiz): ");
        return new Grade(name, score[0], score[1], weightage, tag);
    }

    

    private static double[] inputScore() {
        while (true) {
            String value = EasierConsole.input("Enter score (scored/total, ex: 5/10): ");
            String[] parts = value.trim().split("/", -1);
            if (parts.length == 2) {
                try {
                    double scored = Double.parseDouble(parts[0].trim());
                    double total = Double.parseDouble(parts[1].trim());
                    if (total > 0 && scored >= 0 && scored <= total) {
                        return new double[] {scored, total};
                    }
                } catch (NumberFormatException ignored) {
                    // Show the same prompt again for malformed scores.
                }
            }
            System.out.println("Enter the score as scored/total, such as 5/10.");
        }
    }
}