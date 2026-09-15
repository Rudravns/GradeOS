import java.io.Serializable;

public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double scoredPoints;
    private double totalPoints;
    private double weightage;
    private String tag;

    public Grade(String name, double scoredPoints, double totalPoints, double weightage, String tag) {
        setName(name);
        setTotalPoints(totalPoints);
        setScoredPoints(scoredPoints);
        setWeightage(weightage);
        setTag(tag);
    }

    public double getPercentage() {
        return scoredPoints / totalPoints * 100.0;
    }

    public String getName() {
        return name;
    }

    public double getWeightage() {
        return weightage;
    }

    public double getScoredPoints() {
        return scoredPoints;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public String getTag() {
        return tag;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Grade name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setScoredPoints(double scoredPoints) {
        validateFinite(scoredPoints);
        if (scoredPoints < 0 || scoredPoints > totalPoints) {
            throw new IllegalArgumentException("Scored points must be between 0 and total points.");
        }
        this.scoredPoints = scoredPoints;
    }

    public void setTotalPoints(double totalPoints) {
        validateFinite(totalPoints);
        if (totalPoints <= 0) {
            throw new IllegalArgumentException("Total points must be greater than 0.");
        }
        if (scoredPoints > totalPoints) {
            throw new IllegalArgumentException("Total points cannot be less than scored points.");
        }
        this.totalPoints = totalPoints;
    }

    public void setWeightage(double weightage) {
        validateFinite(weightage);
        if (weightage <= 0 || weightage > 100) {
            throw new IllegalArgumentException("Grade weightage must be between 0 and 100%.");
        }
        this.weightage = weightage;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? "" : tag.trim();
    }

    private void validateFinite(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Grade values must be finite numbers.");
        }
    }

    @Override
    public String toString() {
        String label = tag.isEmpty() ? "" : " | " + tag;
        return String.format("%s: %.2f / %.2f (%.2f%%) | Weight: %.2f%%%s",
            name, scoredPoints, totalPoints, getPercentage(), weightage, label);
    }
}
