package zhitnik;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**test class.*/
public class ElectronicGradeBookTest {

    @Test
    public void testCalculateOverallGpa() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(4, 5));
        gradesBySubject.put("English", Arrays.asList(3, 4));
        gradesBySubject.put("Programming", Arrays.asList(4, 4));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Alina",
                gradesBySubject, 4, 4);
        Assertions.assertEquals(4.0, gradeBook.calculateOverallGpa(), 0.01);
    }

    @Test
    public void testIsEligibleForHonorsDegree() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(5, 5));
        gradesBySubject.put("English", Arrays.asList(5, 5));
        gradesBySubject.put("Programming", Arrays.asList(5, 4));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Julia",
                gradesBySubject, 5, 5);
        Assertions.assertTrue(gradeBook.isEligibleForHonorsDegree());
    }


    @Test
    public void testIsEligibleForIncreasedScholarship() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(4, 4));
        gradesBySubject.put("English", Arrays.asList(3, 4));
        gradesBySubject.put("Programming", Arrays.asList(5, 5));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Klushneva Liza",
                gradesBySubject, 4, 4);
        Assertions.assertFalse(gradeBook.isEligibleForIncreasedScholarship());
    }

    @Test
    public void testAddGradeToSubject() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(4, 4));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Alina",
                gradesBySubject, 4, 4);
        gradeBook.addGrade("Biology", 3);
        Assertions.assertEquals(Arrays.asList(3), gradeBook.getGradesForSubject("Biology"));
    }
}
