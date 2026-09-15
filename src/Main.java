import Saver.ReadFile;
import Saver.SaveFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import utils.*;

public class Main {

    /*
    To run the code:
    cd "C:\Rudransh\Projects\GradeOS\src"
    javac *.java utils/*.java
    java Main

    or

    & 'C:/Users/kumar1272/.jdks/openjdk-26.0.2/bin/javac.exe' -d out/production/GradeOS src/Main.java src/Student.java src/utils/PrettyConsole.java
    & 'C:/Users/kumar1272/.jdks/openjdk-26.0.2/bin/java.exe' -classpath out/production/GradeOS Main


    to fix the bom issue?
    $path = 'src\Main.java'; $bytes = [System.IO.File]::ReadAllBytes($path); if ($bytes.Length -ge 3 -and $bytes[0] -eq 239 -and $bytes[1] -eq 187 -and $bytes[2] -eq 191) { [System.IO.File]::WriteAllBytes($path, $bytes[3..($bytes.Length - 1)]) };
     $sources = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }; 
     & 'C:\Users\kumar1272\.jdks\openjdk-26.0.2\bin\javac.exe' -d out\production\GradeOS $sources; Write-Output 
     "javac exit code: $LASTEXITCODE"
    */

    static StudentDatabase all_students = new StudentDatabase();
    private static final String SAVE_FOLDER = "Save_data";

    // MAIN LOOP - Main Menu
    public static void main(String[] args) {
        while (true) {
            EasierConsole.clearConsole();
            PrettyConsole.divider('=', 50, "GradeOS");

            System.out.println();
            PrettyConsole.showOptions(Commands.MainMenuOptions.values());
            System.out.println();

            PrettyConsole.divider('=', 50);

            String user = EasierConsole.input("Enter command number or name: ");
            PrettyConsole.commandEvaluation(user, Commands.MainMenuOptions.values(), Main::executeMainCommand);
        }
    }

    // STUDENTS MENU
    public static void showStudents() {
        while (true) {
            EasierConsole.clearConsole();
            PrettyConsole.divider('=', 50, "Students");
            System.out.println();

            PrettyConsole.show_array(all_students.toArray());

            System.out.println();
            PrettyConsole.divider('-', 50);
            System.out.println();

            PrettyConsole.showOptions(Commands.StudentsMenuOptions.values());
            System.out.println();

            PrettyConsole.divider('=', 50);

            String user = EasierConsole.input("Enter command number or name: ");

            boolean[] shouldExit = {false};
            PrettyConsole.commandEvaluation(user, Commands.StudentsMenuOptions.values(), option -> {
                if (executeStudentCommand(option)) shouldExit[0] = true;
            });

            if (shouldExit[0]) return;
        }
    }

    // GRADEBOOK MENU   
    public static void openGradebook(Student child){
        while (true) {
            EasierConsole.clearConsole();
            PrettyConsole.divider('=', 50, "GradeBook for " + child.toString());
            System.out.println();
            
            if (child.hasGrades()) {
                PrettyConsole.blinkText(String.format("Overall GPA: %.2f", child.getGpa()));
                PrettyConsole.blinkText("Overall Letter Grade: " + child.getLetter());
                PrettyConsole.blinkText(String.format("Overall Percentage: %.2f%%", child.getPercent()));
            } else {
                PrettyConsole.blinkText("No grades entered yet.");
            }
            PrettyConsole.blinkText("Grade: " + child.getGradeLabel());
            System.out.println();
            PrettyConsole.blinkText("Subjects:");
            if (child.getSubjects().isEmpty()) {
                System.out.println("No subjects added yet.");
            } else {
                int subjectNumber = 1;
                for (Subject subject : child.getSubjects()) {
                    System.out.println(subjectNumber + ". " + subject);
                    subjectNumber++;
                }
            }

            System.out.println();
            PrettyConsole.divider('-', 50);
            System.out.println();

            PrettyConsole.showOptions(Commands.GradebookMenuOptions.values());
            System.out.println();

            PrettyConsole.divider('=', 50);

            String user = EasierConsole.input("Enter command number or name: ");

            boolean[] shouldExit = {false};
            PrettyConsole.commandEvaluation(user, Commands.GradebookMenuOptions.values(), option -> {
                if (executeGradebookCommand(child, option)) {
                    shouldExit[0] = true;
                }
            });

            if (shouldExit[0]) {
                return;
            }
        }
    }

    static boolean executeGradebookCommand(Student student, Commands.GradebookMenuOptions option) {
        if (option == Commands.GradebookMenuOptions.MANAGE_SUBJECTS) {
            manageSubjects(student);
            return false;
        }
        return true;
    }

    static void manageSubjects(Student student) {
        while (true) {
            EasierConsole.clearConsole();
            PrettyConsole.divider('=', 50, "Subjects");
            System.out.println();
            PrettyConsole.show_array(student.getSubjects());
            System.out.println();
            PrettyConsole.showOptions(Commands.SubjectsMenuOptions.values());
            PrettyConsole.divider('=', 50);

            String user = EasierConsole.input("Enter command number or name: ");
            boolean[] shouldExit = {false};
            PrettyConsole.commandEvaluation(user, Commands.SubjectsMenuOptions.values(), option -> {
                try {
                    switch (option) {
                        case ADD_SUBJECT:
                            EasierConsole.clearConsole();
                            PrettyConsole.divider('=', 50, "Add Subject");
                            System.out.println();
                            student.addSubject(Commands.addSubject());
                            System.out.println("Subject added successfully.");
                            PrettyConsole.pause();
                            break;
                        case REMOVE_SUBJECT:
                            EasierConsole.clearConsole();
                            PrettyConsole.divider('=', 50, "Remove Subject");
                            System.out.println();
                            int removeNumber = EasierConsole.inputInt("Enter subject number to remove (0 to cancel): ");
                            if (removeNumber > 0 && !student.removeSubject(removeNumber - 1)) {
                                System.out.println("That subject number does not exist.");
                                PrettyConsole.pause();
                            } else if (removeNumber > 0) {
                                System.out.println("Subject removed successfully.");
                                PrettyConsole.pause();
                            }
                            break;
                        case OPEN_SUBJECT:
                            EasierConsole.clearConsole();
                            PrettyConsole.divider('=', 50, "Open Subject");
                            System.out.println();
                            PrettyConsole.show_array(student.getSubjects());
                            System.out.println();
                            int subjectNumber = EasierConsole.inputInt("Enter subject number to open (0 to cancel): ");
                            if (subjectNumber > 0 && subjectNumber <= student.getSubjects().size()) {
                                manageGrades(student.getSubjects().get(subjectNumber - 1));
                            } else if (subjectNumber > 0) {
                                System.out.println("That subject number does not exist.");
                                PrettyConsole.pause();
                            }
                            break;
                        case EXIT:
                            shouldExit[0] = true;
                            break;
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                    PrettyConsole.pause();
                }
            });
            if (shouldExit[0]) return;
        }
    }

    static void manageGrades(Subject subject) {
        while (true) {
            EasierConsole.clearConsole();
            PrettyConsole.divider('=', 50, subject.getName());
            System.out.println();
            if (subject.getGrades().isEmpty()) {
                System.out.println("No grades entered yet.");
            } else {
                int gradeNumber = 1;
                for (Grade grade : subject.getGrades()) {
                    System.out.println(gradeNumber++ + ". " + grade);
                }
                System.out.printf("Grade: %.2f%% | GPA: %.1f | %s%n",
                        subject.getPercentage(), subject.getGpa(), subject.getLetterGrade());
            }
            System.out.println();
            PrettyConsole.showOptions(Commands.GradesMenuOptions.values());
            PrettyConsole.divider('=', 50);

            String user = EasierConsole.input("Enter command number or name: ");
            boolean[] shouldExit = {false};
            PrettyConsole.commandEvaluation(user, Commands.GradesMenuOptions.values(), option -> {
                try {
                    switch (option) {
                        case ADD_GRADE:
                            EasierConsole.clearConsole();
                            PrettyConsole.divider('=', 50, "Add Grade");
                            System.out.println();
                            subject.addGrade(Commands.addGrade());
                            System.out.println("Grade added successfully.");
                            PrettyConsole.pause();
                            break;
                        case REMOVE_GRADE:
                            EasierConsole.clearConsole();
                            PrettyConsole.divider('=', 50, "Remove Grade");
                            System.out.println();
                            List<Grade> grade = subject.getGrades();
                            for (int i = 0; i<grade.size() ;i++){
                                PrettyConsole.blinkText(Integer.toString(i + 1)+". " + grade.get(i));
                            }
                            PrettyConsole.divider('-', 50);
                            int gradeNumber = EasierConsole.inputInt("Enter grade number to remove (0 to cancel): ");
                            if (gradeNumber > 0 && !subject.removeGrade(gradeNumber - 1)) {
                                System.out.println("That grade number does not exist.");
                                PrettyConsole.pause();
                            } else if (gradeNumber > 0) {
                                System.out.println("Grade removed successfully.");
                                PrettyConsole.pause();
                            }
                            break;
                        case EXIT:
                            shouldExit[0] = true;
                            break;
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                    PrettyConsole.pause();
                }
            });
            if (shouldExit[0]) return;
        }
    }

    // MAIN MENU HANDLERS
    static void executeMainCommand(Commands.MainMenuOptions option) {
        switch (option) {
            case VIEW_STUDENTS:
                showStudents();
                break;
            case SAVE_STUDENTS:
                saveStudents();
                break;
            case LOAD_STUDENTS:
                loadStudents();
                break;
            case EXIT:
                EasierConsole.clearConsole();
                PrettyConsole.divider('=', 50, "GradeOS");
                System.out.println();
                PrettyConsole.blinkText("Goodbye! See you next time.");
                System.exit(0);
        }
    }

    private static void saveStudents() {
        EasierConsole.clearConsole();
        PrettyConsole.divider('=', 50, "Save Students");
        System.out.println();

        String fileName = promptSaveFileName();
        if (fileName == null) return;

        if (SaveFile.save(all_students, fileName, SAVE_FOLDER)) {
            System.out.println("Saved successfully as " + fileName + ".");
        } else {
            System.out.println("The save could not be written.");
        }
        PrettyConsole.pause();
    }

    private static String promptSaveFileName() {
        while (true) {
            String fileName = EasierConsole.input("Enter save name (0 to cancel): ").trim();
            if (fileName.equals("0") || fileName.equalsIgnoreCase("quit")) return null;
            if (fileName.isEmpty()) {
                System.out.println("Save name cannot be empty.");
                continue;
            }
            if (!fileName.endsWith(".ser")) fileName += ".ser";
            if (fileName.matches(".*[<>:\"/\\\\|?*].*")) {
                System.out.println("Use a file name without path separators or special characters.");
                continue;
            }
            return fileName;
        }
    }

    private static void loadStudents() {
        EasierConsole.clearConsole();
        PrettyConsole.divider('=', 50, "Load Students");
        System.out.println();

        List<Path> saveFiles;
        try {
            Path saveDirectory = Path.of(SAVE_FOLDER);
            if (!Files.exists(saveDirectory)) {
                saveFiles = List.of();
            } else {
                try (var fileStream = Files.list(saveDirectory)) {
                    saveFiles = fileStream
                            .filter(path -> path.getFileName().toString().toLowerCase().endsWith(".ser"))
                            .sorted(Comparator.comparing(path -> path.getFileName().toString().toLowerCase()))
                            .toList();
                }
            }
        } catch (IOException exception) {
            saveFiles = List.of();
        }

        if (saveFiles.isEmpty()) {
            System.out.println("No save files found.");
            PrettyConsole.pause();
            return;
        }

        for (int index = 0; index < saveFiles.size(); index++) {
            System.out.println((index + 1) + ". " + saveFiles.get(index).getFileName());
        }
        System.out.println();

        int selection = EasierConsole.inputInt("Enter save number to load (0 to cancel): ");
        if (selection == 0) return;
        if (selection < 1 || selection > saveFiles.size()) {
            System.out.println("That save number does not exist.");
            PrettyConsole.pause();
            return;
        }

        Object loadedObject = ReadFile.read(
                saveFiles.get(selection - 1).getFileName().toString(), SAVE_FOLDER);
        if (loadedObject instanceof StudentDatabase loadedDatabase) {
            all_students = loadedDatabase;
            System.out.println("Loaded " + saveFiles.get(selection - 1).getFileName() + " successfully.");
        } else {
            System.out.println("That file is not a valid GradeOS save.");
        }
        PrettyConsole.pause();
    }

    // STUDENT MENU HANDLERS - returns true to signal going back to main menu
    static boolean executeStudentCommand(Commands.StudentsMenuOptions option) {
        switch (option) {
            case OPEN_GRADEBOOK:
                EasierConsole.clearConsole();
                PrettyConsole.divider('=', 50, "Open GradeBook");
                System.out.println();
                PrettyConsole.show_array(all_students.toArray());
                if (!all_students.isEmpty()) {
                    int studentNumber = EasierConsole.inputInt("Enter student number to open his/hers gradebook (0 to cancel): ");
                    if (studentNumber == 0) {
                        return false;
                    }
                    if (studentNumber < 1 || studentNumber > all_students.size()) {
                        System.out.println("That student number does not exist.");
                        PrettyConsole.pause();
                    } else {
                        Student child = all_students.get(studentNumber - 1);
                        openGradebook(child);
                    }
                }
                return false;

            case ADD_STUDENT:
                Student newStudent = Commands.addStudent();
                all_students.add(newStudent);
                EasierConsole.clearConsole();
                PrettyConsole.divider('=', 50, "Add Student");
                System.out.println();
                System.out.println("Student added successfully!");
                PrettyConsole.pause();
                return false;
            case REMOVE_STUDENTS:
                EasierConsole.clearConsole();
                PrettyConsole.divider('=', 50, "Remove Students");
                System.out.println();
                PrettyConsole.show_array(all_students.toArray());
                if (!all_students.isEmpty()) {
                    int studentNumber = EasierConsole.inputInt("Enter student number to remove (0 to cancel): ");
                    if (studentNumber == 0) return false;
                    if (studentNumber < 1 || studentNumber > all_students.size()) {
                        System.out.println("That student number does not exist.");
                    } else {
                        Student removedStudent = all_students.remove(studentNumber - 1);
                        System.out.println(removedStudent.getName() + " was removed.");
                    }
                    PrettyConsole.pause();
                } else {
                    PrettyConsole.pause();
                }
                return false;
            case EXIT:
                return true;
            default:
                System.out.println("Invalid command.");
                PrettyConsole.pause();
                return false;
        }
    }

}