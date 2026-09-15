# GradeOS

GradeOS is a Java console gradebook for managing students, subjects, and weighted grades.

It supports:

- Student profiles with names and grades from 1st through 12th grade
- Separate gradebooks for each student
- Standard, AP, and Honors subjects
- Weighted grade entries
- Point-based scores such as `5/10`
- Optional grade tags such as `quiz`, `test`, or `project`
- Letter grades and GPA values on a 5.0 scale
- Adding and removing students, subjects, and grades
- `0` and `quit` commands for leaving menus

## Requirements

- Windows
- Java JDK 26 or a compatible JDK
- The Oracle Java executable must be available on PATH, or installed at the path configured by your machine

## Project Structure

```text
GradeOS/
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── Subject.java
│   ├── Grade.java
│   ├── Commands.java
│   └── utils/
│       ├── EasierConsole.java
│       ├── MenuOption.java
│       └── PrettyConsole.java
├── .vscode/
│   ├── launch.json
│   ├── settings.json
│   └── tasks.json
├── README.md
└── REQUIREMENTS.md
```

### Main classes

- `Main.java` runs the application and controls the menus.
- `Student.java` stores a student's name, grade level, subjects, overall percentage, letter grade, and GPA.
- `Subject.java` stores a subject's grades and applies the AP/Honors boost.
- `Grade.java` stores one named grade entry.
- `Commands.java` defines menu commands and collects input.
- `PrettyConsole.java` formats console output and evaluates menu commands.
- `EasierConsole.java` provides reusable text, integer, decimal, and screen-input helpers.

## Running the Application

Run these commands from the project root, the folder containing `README.md`:

```powershell
cd "C:\Rudransh\Projects\GradeOS"

javac -d out src\Main.java src\Student.java src\Subject.java src\Grade.java src\Commands.java src\utils\MenuOption.java src\utils\EasierConsole.java src\utils\PrettyConsole.java

java -cp out Main
```

Do not run only `javac Main.java` from the `src` folder. The application depends on several other source files and packages.

## VS Code Run Button

The workspace includes a Java launch configuration in `.vscode/launch.json` and a compile task in `.vscode/tasks.json`.

To run from VS Code:

1. Open the project root folder in VS Code.
2. Open `Main.java`.
3. Select `Run GradeOS` if VS Code asks for a configuration.
4. Click the top-right run button.

Code Runner is configured to use the integrated Terminal instead of the Output panel.

## Menu Flow

```text
Main Menu
└── View Students
    ├── Open Gradebook
    │   └── Manage Subjects
    │       ├── Add Subject
    │       ├── Remove Subject
    │       └── Open Subject Grades
    │           ├── Add Grade
    │           └── Remove Grade
    ├── Add Student
    └── Remove Student
```

The application saves the current student database as a Java serialized `.ser` file in `Save_data/`.
Choose **Save Students**, enter a name, and the `.ser` extension is added automatically. Choose
**Load Students** to see the available `.ser` files, then select one by number. Enter `0` to cancel
either operation. Files that are not valid GradeOS saves are reported without replacing the current data.

## Student Information

When adding a student, GradeOS asks for:

- Student name
- Grade level from 1 through 12

The grade level is displayed using an ordinal label, such as:

```text
1st grade
2nd grade
3rd grade
11th grade
12th grade
```

## Subjects

When adding a subject, GradeOS asks for:

- Subject name
- Whether it is an AP or Honors subject

A subject starts with no grades. It does not display a fake percentage, letter grade, or GPA before grades are entered.

AP and Honors subjects receive a 10 percentage-point boost after their grades are calculated. The result is capped at 100%.

Example:

```text
Raw grade: 78%
AP/Honors boost: +10%
Final grade: 88%
```

## Grades

Each grade entry contains:

- Grade name
- Score in `scored/total` format
- Weightage from 0 to 100%
- Optional tag

Example input:

```text
Name: Chapter 1 Quiz
Score: 5/10
Weightage: 20
Tag: quiz
```

The grade is displayed like this:

```text
Chapter 1 Quiz: 5.00 / 10.00 (50.00%) | Weight: 20.00% | quiz
```

A subject's percentage is calculated from the weighted average of its grade entries. Only subjects with at least one grade contribute to the student's overall results.

## GPA and Letter Grades

GradeOS uses a 5.0 GPA scale. The GPA is calculated from the final subject percentage, after any AP/Honors boost.

| Percentage | Letter | GPA |
|---:|:---:|---:|
| 97-100 | A+ | 5.0 |
| 93-96 | A | 4.7 |
| 90-92 | A- | 4.3 |
| 87-89 | B+ | 4.0 |
| 83-86 | B | 3.7 |
| 80-82 | B- | 3.3 |
| 77-79 | C+ | 3.0 |
| 73-76 | C | 2.7 |
| 70-72 | C- | 2.3 |
| 60-69 | D | 2.0 |
| 0-59 | F | 0.0 |

If a student has no grades, the gradebook displays:

```text
No grades entered yet.
```

## Leaving Menus

Every menu accepts either of these commands to go back:

```text
0
quit
```

The normal menu option names and numbers are also supported.

## Development Notes

The project stores data in memory while running and can persist the complete student database through
the Save and Load menu entries.
