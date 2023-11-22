package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**test class.*/
public class ElectronicGradeBookTest {

    @Test
    public void testCalculateOverallGpa() {
        double[] grades = {4.5, 4.8, 4.9, 5.0};
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Alina", grades, 4.7, 5.0);

        double expectedOverallGPA = 4.8;
        double actualOverallGPA = gradeBook.calculateOverallGpa();

        Assertions.assertEquals(expectedOverallGPA, actualOverallGPA, 0.001);
    }

    @Test
    public void testIsEligibleForHonorsDegree() {
        double[] grades = {4.5, 4.8, 4.9, 5.0};
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Alina", grades, 4.7, 5.0);

        boolean expectedEligibleForHonorsDegree = false;
        boolean actualEligibleForHonorsDegree = gradeBook.isEligibleForHonorsDegree();

        Assertions.assertEquals(expectedEligibleForHonorsDegree, actualEligibleForHonorsDegree);
    }

    @Test
    public void testIsEligibleForIncreasedScholarship() {
        double[] grades = {4.5, 4.8, 4.9, 5.0};
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Alina", grades, 4.7, 5.0);

        boolean expectedEligibleForIncreasedScholarship = true;
        boolean actualEligibleForIncreasedScholarship = gradeBook.isEligibleForIncreasedScholarship();

        Assertions.assertEquals(expectedEligibleForIncreasedScholarship, actualEligibleForIncreasedScholarship);
    }
}

