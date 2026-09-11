# GradeForge

## Student Gradebook & Performance Analyzer

GradeForge is a Java-based student gradebook and performance analysis program. It creates student objects, stores academic information, calculates statistics, compares students, and generates a readable final report.

The project is designed around the **AP Computer Science A Units 1–2** requirements while adding useful features such as **What-If Grade Analysis** and optional **JSON data persistence**.

---

## Project Goals

GradeForge should demonstrate:

- Java classes and objects
- Constructors
- Instance variables
- Encapsulation
- Accessor and mutator methods
- Arithmetic and calculations
- Integer and decimal division
- Type casting
- Compound assignment
- `Math` methods
- String methods
- Clean console output
- Object state changes
- Student and class-level grade analysis
- Optional file persistence using JSON

The goal is to make the project feel like a small, real grade analytics application rather than a collection of disconnected requirement checks.

---

## Project Structure

Recommended IntelliJ project structure:

```text
GradeForge/
│
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── Gradebook.java
│
├── data/
│   └── students.json
│
├── README.md
└── REQUIREMENTS.md
```

### Classes

### `Student.java`

Represents one student.

Responsible for:

- Storing student information
- Returning student information
- Updating grades
- Calculating student-level statistics
- Determining letter grades
- Performing student-specific calculations

### `Gradebook.java`

Represents the gradebook/analysis system.

Responsible for:

- Working with multiple Student objects
- Calculating class-level statistics
- Comparing students
- Producing gradebook-level analysis

### `Main.java`

The driver class.

Responsible for:

- Creating Student objects
- Calling methods
- Demonstrating required concepts
- Running the analysis
- Printing the final report

### `data/students.json`

Optional persistent storage for student information.

---

# Core GradeForge Features

## 1. Student Profiles

Each Student object should contain at least five pieces of information.

Possible data:

```text
Name
Grade Level
Math Grade
Science Grade
English Grade
History Grade
```

You may change these fields if another set of academic data makes more sense.

---

## 2. Student Statistics

GradeForge should calculate useful statistics such as:

- Student average
- Letter grade
- Highest grade
- Lowest grade
- Class average
- Difference between students
- Grade improvement
- Performance score

---

## 3. Student Comparison

The program should compare at least two students.

Possible comparisons:

```text
Average Difference
Highest Individual Grade
Lowest Individual Grade
Performance Difference
Grade Improvement
```

Example:

```text
Student A Average: 91.50%
Student B Average: 87.25%
Difference: 4.25%
```

---

# Original Feature

## What-If Grade Calculator

The main original feature will be a **What-If Grade Calculator**.

The program can change a student's grade after the Student object has already been created and then calculate the effect.

Example:

```text
===== WHAT-IF ANALYSIS =====

Student: Alex Johnson

Original Science Grade: 84%
New Science Grade: 94%

Original Average: 88.75%
New Average: 91.25%

Improvement: +2.50%
```

This feature demonstrates object state changes, arithmetic, division, and method calls.

---

# Optional Advanced Feature

## JSON Persistence

GradeForge can optionally save and load student information using:

```text
data/students.json
```

The JSON file may contain:

```text
name
gradeLevel
mathGrade
scienceGrade
englishGrade
historyGrade
```

The intended workflow is:

```text
students.json
      ↓
Read data
      ↓
Create Student objects
      ↓
Gradebook analysis
      ↓
Modify grades / calculate results
      ↓
Save updated data
```

JSON persistence is an **extra feature**. The core program should still satisfy all AP CSA Units 1–2 requirements without depending on JSON.

---

# Example Final Output

The exact values and formatting are up to you.

```text
========================================
             GRADEFORGE
       STUDENT PERFORMANCE ANALYZER
========================================

STUDENT 1
Name: Alex Johnson
Grade Level: 10

Math: 94%
Science: 87%
English: 91%
History: 89%

Average: 90.25%
Letter Grade: A
Initials: AJ

----------------------------------------

STUDENT 2
Name: Maya Patel
Grade Level: 10

Math: 96%
Science: 93%
English: 88%
History: 95%

Average: 93.00%
Letter Grade: A
Initials: MP

----------------------------------------

CLASS ANALYSIS

Class Average: 91.63%
Average Difference: 2.75%
Highest Grade: 96%

Higher Average: Maya Patel

----------------------------------------

WHAT-IF ANALYSIS

Alex's Original Average: 90.25%
Alex's New Average: 92.00%
Improvement: +1.75%

========================================
```

---

# Development Order

Build GradeForge in this order:

### Phase 1 — Student Class

1. Create `Student.java`.
2. Add at least five private instance variables.
3. Include at least one `int` and one `double`.
4. Create a parameterized constructor.
5. Create getter/accessor methods.
6. Create mutator/action methods.
7. Create the average calculation.
8. Create the letter-grade calculation.
9. Add meaningful String methods.
10. Add a `Math` method.

### Phase 2 — Main

1. Create `Main.java`.
2. Create at least three Student objects.
3. Give every student different data.
4. Call Student methods.
5. Change at least one Student after creation.
6. Calculate statistics.
7. Compare students.
8. Print the final report.

### Phase 3 — Gradebook

1. Create `Gradebook.java`.
2. Add class-level calculations.
3. Calculate class average.
4. Compare student performance.
5. Add additional useful analysis.

### Phase 4 — Original Feature

1. Implement the What-If Grade Calculator.
2. Show the original result.
3. Change a grade.
4. Recalculate the result.
5. Show the difference.
6. Add a comment explaining the feature.

### Phase 5 — JSON

Only after the core project works:

1. Create `data/students.json`.
2. Decide on the JSON structure.
3. Implement writing.
4. Implement reading.
5. Test that saved data can be loaded correctly.

### Phase 6 — Testing

1. Compile the entire project.
2. Run it with different student data.
3. Check every AP CSA requirement.
4. Check the final report.
5. Check the What-If feature.
6. Test JSON if implemented.
7. Clean up comments, naming, and formatting.

---

# Design Philosophy

GradeForge should follow a simple separation of responsibilities:

```text
Student
  ↓
Student-specific data and calculations

Gradebook
  ↓
Multiple-student analysis

Main
  ↓
Program execution and final report

JSON
  ↓
Optional data persistence
```

Avoid putting everything inside `Main.java`. The purpose of the class structure is to demonstrate that each object/class has a clear responsibility.

---

## Requirements Checklist

See [`REQUIREMENTS.md`](REQUIREMENTS.md) for the complete requirement-by-requirement checklist.

---

## Tech Stack

- **Language:** Java
- **IDE:** IntelliJ IDEA
- **Project Type:** Java console application
- **Data Storage:** JSON (optional advanced feature)
- **Core Concepts:** AP CSA Units 1–2

---

## Status

**Current Stage:** Planning

- [ ] Project created in IntelliJ
- [ ] `Student.java` created
- [ ] `Gradebook.java` created
- [ ] `Main.java` created
- [ ] Student class completed
- [ ] Required AP CSA concepts completed
- [ ] Gradebook analysis completed
- [ ] What-If feature completed
- [ ] JSON persistence completed
- [ ] Testing completed
- [ ] Final report polished
- [ ] Ready for submission
