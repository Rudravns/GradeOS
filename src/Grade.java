public class Grade {
    private final String name;
    private final double scoredPoints;
    private final double totalPoints;
    private final double weightage;
    private final String tag;

    public Grade(String name, double scoredPoints, double totalPoints, double weightage, String tag) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Grade name cannot be empty.");
        }
        if (totalPoints <= 0) {
            throw new IllegalArgumentException("Total points must be greater than 0.");
        }
        if (scoredPoints < 0 || scoredPoints > totalPoints) {
            throw new IllegalArgumentException("Scored points must be between 0 and total points.");
        }
        if (weightage <= 0 || weightage > 100) {
            throw new IllegalArgumentException("Grade weightage must be between 0 and 100%.");
        }
        this.name = name.trim();
        this.scoredPoints = scoredPoints;
        this.totalPoints = totalPoints;
        this.weightage = weightage;
        this.tag = tag == null ? "" : tag.trim();
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

    @Override
    public String toString() {
        String label = tag.isEmpty() ? "" : " | " + tag;
        return String.format("%s: %.2f / %.2f (%.2f%%) | Weight: %.2f%%%s",
            name, scoredPoints, totalPoints, getPercentage(), weightage, label);
    }
}
