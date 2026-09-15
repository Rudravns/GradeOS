
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int year;
    private final ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String name, int year) {
        setName(name);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public int getYear(boolean number) {
        return year;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setYear(int year) {
        if (year < 1 || year > 12) {
            throw new IllegalArgumentException("Student grade must be between 1 and 12.");
        }
        this.year = year;
    }

    public String getGradeLabel() {
        String suffix = "th";
        if (year % 100 < 11 || year % 100 > 13) {
            suffix = switch (year % 10) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
        }
        return year + suffix + " grade";
    }

    public void addSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
        subjects.add(subject);
    }

    public boolean removeSubject(int index) {
        if (index < 0 || index >= subjects.size()) return false;
        subjects.remove(index);
        return true;
    }

    public List<Subject> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }

    public boolean hasGrades() {
        for (Subject subject : subjects) {
            if (subject.hasGrades()) return true;
        }
        return false;
    }

    public double getPercent() {
        double totalWeight = 0;
        double weightedTotal = 0;
        for (Subject subject : subjects) {
            if (!subject.hasGrades()) continue;
            weightedTotal += subject.getPercentage();
            totalWeight++;
        }
        return totalWeight == 0 ? 0 : weightedTotal / totalWeight;
    }

    public double getGpa() {
        double totalWeight = 0;
        double weightedGpa = 0;
        for (Subject subject : subjects) {
            if (!subject.hasGrades()) continue;
            weightedGpa += subject.getGpa();
            totalWeight++;
        }
        return totalWeight == 0 ? 0 : weightedGpa / totalWeight;
    }

    public String getLetter() {
        double percent = getPercent();
        if (percent >= 97) return "A+";
        if (percent >= 93) return "A";
        if (percent >= 90) return "A-";
        if (percent >= 87) return "B+";
        if (percent >= 83) return "B";
        if (percent >= 80) return "B-";
        if (percent >= 77) return "C+";
        if (percent >= 73) return "C";
        if (percent >= 70) return "C-";
        if (percent >= 60) return "D";
        return "F";
    }
    
    @Override
    public String toString() { // Override the toString method to provide a string representation of the student(which is thier name)
        return name;
    }

}
