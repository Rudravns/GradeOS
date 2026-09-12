import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final String name;
    private final boolean advanced;
    private final ArrayList<Grade> grades = new ArrayList<>();

    public Subject(String name, boolean advanced) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        this.name = name.trim();
        this.advanced = advanced;
    }

    public String getName() {
        return name;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public boolean removeGrade(int index) {
        if (index < 0 || index >= grades.size()) return false;
        grades.remove(index);
        return true;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public boolean hasGrades() {
        return !grades.isEmpty();
    }

    public double getRawPercentage() {
        double totalWeight = 0;
        double weightedTotal = 0;
        for (Grade grade : grades) {
            weightedTotal += grade.getPercentage() * grade.getWeightage();
            totalWeight += grade.getWeightage();
        }
        return totalWeight == 0 ? 0 : weightedTotal / totalWeight;
    }

    public double getPercentage() {
        if (!hasGrades()) return 0;
        return Math.min(100, getRawPercentage() + (advanced ? 10 : 0));
    }

    public String getLetterGrade() {
        return letterFor(getPercentage());
    }

    public double getGpa() {
        double percentage = getPercentage();
        if (percentage >= 97) return 5.0;
        if (percentage >= 93) return 4.7;
        if (percentage >= 90) return 4.3;
        if (percentage >= 87) return 4.0;
        if (percentage >= 83) return 3.7;
        if (percentage >= 80) return 3.3;
        if (percentage >= 77) return 3.0;
        if (percentage >= 73) return 2.7;
        if (percentage >= 70) return 2.3;
        if (percentage >= 60) return 2.0;
        return 0.0;
    }

    private String letterFor(double percentage) {
        if (percentage >= 97) return "A+";
        if (percentage >= 93) return "A";
        if (percentage >= 90) return "A-";
        if (percentage >= 87) return "B+";
        if (percentage >= 83) return "B";
        if (percentage >= 80) return "B-";
        if (percentage >= 77) return "C+";
        if (percentage >= 73) return "C";
        if (percentage >= 70) return "C-";
        if (percentage >= 60) return "D";
        return "F";
    }

    @Override
    public String toString() {
        String level = advanced ? "AP/Honors" : "Standard";
        if (!hasGrades()) return name + " | " + level + " | No grades yet";
        return String.format("%s | %s | %.2f%% | %s | GPA %.1f",
                name, level, getPercentage(), getLetterGrade(), getGpa());
    }
}
