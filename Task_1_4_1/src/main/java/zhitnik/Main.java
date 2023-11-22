package zhitnik;

public class Main {
    public static void main(String[] args) {
        double[] grades = {4.5, 4.8, 4.9, 5.0};
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("John Doe", grades, 4.7, 5.0);

        double overallGPA = gradeBook.calculateOverallGPA();
        System.out.println("Overall GPA: " + overallGPA);

        boolean isEligibleForHonorsDegree = gradeBook.isEligibleForHonorsDegree();
        System.out.println("Eligible for honors degree: " + isEligibleForHonorsDegree);

        boolean isEligibleForIncreasedScholarship = gradeBook.isEligibleForIncreasedScholarship();
        System.out.println("Eligible for increased scholarship: " + isEligibleForIncreasedScholarship);
    }
}
