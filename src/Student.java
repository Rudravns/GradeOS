
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final int year;
    private final ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear(boolean number) {
        return year;
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
        subjects.add(subject);
    }

    public boolean removeSubject(int index) {
        if (index < 0 || index >= subjects.size()) return false;
        subjects.remove(index);
        return true;
    }

    public List<Subject> getSubjects() {
        return subjects;
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
