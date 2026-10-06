public class UITStudent {
    private int studentId;
    private String fullName;
    private String major;
    private double GPA;

    public UITStudent() {
        this(0, "Unknown", "Unknown", 0.0);
    }

    public UITStudent(int studentId, String fullName) {
        this(studentId, fullName, "Unknown", 0.0);
    }

    public UITStudent(int studentId, String fullName, String major, double GPA) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.GPA = GPA;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + GPA);
        System.out.println("Passed: " + isPassed());
        System.out.println("Classification: " + academicClassification());
    }

    public boolean isPassed() {
        return GPA >= 2.0;
    }

    public String academicClassification() {
        if (GPA >= 3.6) {
            return "Excellent";
        } else if (GPA >= 3.2) {
            return "Very Good";
        } else if (GPA >= 2.5) {
            return "Good";
        } else if (GPA >= 2.0) {
            return "Passed";
        } else {
            return "Poor";
        }
    }
}