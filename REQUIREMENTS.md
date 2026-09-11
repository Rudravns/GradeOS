# GradeForge Requirements

## Project: Student Gradebook & Performance Analyzer

This checklist tracks the AP Computer Science A Units 1–2 requirements for GradeForge, plus the planned original and advanced features.

---

## 1. Classes & Objects

- [ ] Create a custom class representing a student/profile.
- [ ] Create a separate driver class containing `main()`.
- [ ] Create at least **3 Student objects**.
- [ ] Give every Student object different data.
- [ ] Use `new` to create objects.
- [ ] Use a parameterized constructor.
- [ ] Store object information using instance variables.

## 2. Instance Variables

The custom `Student` class must have:

- [ ] At least **5 instance variables**.
- [ ] At least **1 `int`**.
- [ ] At least **1 `double`**.
- [ ] Instance variables should normally be `private`.

Possible variables:
- `name`
- `gradeLevel`
- `mathGrade`
- `scienceGrade`
- `englishGrade`
- `historyGrade`

## 3. Constructors

- [ ] Create at least one parameterized constructor.
- [ ] Use the constructor to initialize object data.
- [ ] Call the constructor with arguments when creating objects.

## 4. Accessor / Getter Methods

Create at least **2 methods that return useful information**.

- [ ] `getName()`
- [ ] `getGradeLevel()`
- [ ] `getMathGrade()`
- [ ] `getAverage()`

## 5. Mutator / Action Methods

Create at least **2 methods that change or act on object data**.

- [ ] At least one method is `void`.
- [ ] At least one `void` method changes the object's state.
- [ ] Call the state-changing method after the object is created.

Possible methods:
- `updateGrade(...)`
- `setMathGrade(...)`
- `addBonus(...)`

## 6. Required Programming Concepts

- [ ] Use primitive variables and appropriate data types.
- [ ] Use both `int` and `double`.
- [ ] Demonstrate assignment and reassignment.
- [ ] Use arithmetic operators such as `+`, `-`, `*`, `/`, and/or `%`.
- [ ] Intentionally demonstrate integer vs. decimal division.
- [ ] Use a type cast for a real purpose.
- [ ] Use a compound assignment such as `+=`, `-=`, `*=`, or `/=`.
- [ ] Use at least one `Math` method.
- [ ] Use at least two meaningful String methods.
- [ ] Create objects using `new`.
- [ ] Call constructors with arguments.
- [ ] Call instance methods and use returned values.
- [ ] Produce clear output using `System.out.println()` or `System.out.printf()`.
- [ ] Add comments explaining non-obvious calculations or design choices.

## 7. Calculations & Statistics

The program must:

- [ ] Calculate at least **3 statistics**.
- [ ] Use division in at least one statistic.
- [ ] Use a `Math` method in at least one statistic.
- [ ] Calculate each student's average.
- [ ] Calculate the class average.
- [ ] Calculate a comparison/difference between students.
- [ ] Include another useful calculation such as highest grade, lowest grade, improvement, or performance score.

## 8. String Requirements

Use at least **2 String methods** meaningfully.

Possible methods:
- `length()`
- `substring()`
- `indexOf()`
- `toUpperCase()`
- `toLowerCase()`

Possible uses:

- [ ] Display student name length.
- [ ] Generate/display initials.
- [ ] Format a student's name.
- [ ] Extract part of a name.

## 9. Final Report

- [ ] Display every student in a readable section.
- [ ] Display student information with labels.
- [ ] Display calculated results.
- [ ] Include units where appropriate.
- [ ] Display at least one comparison between two students.
- [ ] Make the output organized and readable.

## 10. Original Feature

Create at least **one original feature** beyond the required items.

The feature must:

- [ ] Be your own design.
- [ ] Use at least one method from the custom class.
- [ ] Use at least one required programming concept.
- [ ] Produce a visible result in the final report.
- [ ] Have a short explanatory comment in the code.

### Planned Feature: What-If Grade Calculator

- [ ] Change one student's grade after object creation.
- [ ] Calculate the new average.
- [ ] Compare the original and new averages.
- [ ] Display the improvement/difference.

Example:

```text
Original Average: 88.75%
New Average: 91.25%
Improvement: +2.50%
```

## 11. Grade Analysis Features

Recommended GradeForge functionality:

- [ ] Calculate each student's average.
- [ ] Determine each student's letter grade.
- [ ] Find the highest grade.
- [ ] Find the lowest grade.
- [ ] Compare two students.
- [ ] Calculate the class average.
- [ ] Calculate the difference between student averages.
- [ ] Allow a grade to be updated.
- [ ] Display the effect of the grade update.

## 12. JSON Persistence — Advanced Extra

JSON is an optional advanced feature and is **not** a replacement for the AP CSA requirements.

- [ ] Create a `data/` folder.
- [ ] Create `data/students.json`.
- [ ] Write student data to the JSON file.
- [ ] Read student data from the JSON file.
- [ ] Make sure the saved data correctly represents the Student objects.
- [ ] Keep file-handling logic separate from the core `Student` class where practical.

## 13. Code Quality

- [ ] Use meaningful variable names.
- [ ] Use meaningful method names.
- [ ] Use `camelCase` for variables and methods.
- [ ] Use `PascalCase` for class names.
- [ ] Keep instance variables private.
- [ ] Use clear indentation and spacing.
- [ ] Add useful comments.
- [ ] Avoid unnecessary repeated hard-coded values.
- [ ] Keep student-specific behavior in `Student`.
- [ ] Keep program execution/reporting in `Main`.
- [ ] Test with multiple sets of values.
- [ ] Do not add unused code just to check a requirement.

## 14. Testing Before Submission

### Program
- [ ] Program compiles with no errors.
- [ ] Program runs from `Main`.
- [ ] At least 3 Student objects are created.
- [ ] Every student has different data.

### Classes
- [ ] Parameterized constructor works.
- [ ] Instance variables are private.
- [ ] At least 2 accessor methods work.
- [ ] At least 2 mutator/action methods work.
- [ ] At least 1 void method changes an object.

### Programming Concepts
- [ ] `int` used.
- [ ] `double` used.
- [ ] Arithmetic used.
- [ ] Division works as intended.
- [ ] Integer/decimal division demonstrated.
- [ ] Type casting used correctly.
- [ ] Compound assignment used.
- [ ] `Math` method used meaningfully.
- [ ] At least 2 String methods used meaningfully.
- [ ] Objects created with `new`.

### Output
- [ ] All students appear in the report.
- [ ] At least 3 statistics are calculated.
- [ ] At least one calculation uses division.
- [ ] At least one calculation uses `Math`.
- [ ] String methods affect displayed output.
- [ ] Two students are compared.
- [ ] Original feature works.
- [ ] Output is organized and readable.

### JSON
- [ ] Data can be written to JSON.
- [ ] Data can be read from JSON.
- [ ] JSON data correctly represents the students.

## 15. Submission Requirements

- [ ] Submit every `.java` file required to run the program.
- [ ] `Main.java` contains `main()`.
- [ ] Include your name in a comment at the top of each Java file.
- [ ] Project runs without errors.
- [ ] Be prepared to explain the class design.
- [ ] Be prepared to explain the constructor.
- [ ] Be prepared to explain the methods.
- [ ] Be prepared to explain at least 2 calculations.
- [ ] Be prepared to explain the original feature.
