package zhitnik;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Integer> mathGrades = new ArrayList<>(Arrays.asList(5, 5));
        List<Integer> englishGrades = new ArrayList<>(Arrays.asList(5, 5));
        List<Integer> programmingGrades = new ArrayList<>(Arrays.asList(5, 5));
        gradesBySubject.put("Math", mathGrades);
        gradesBySubject.put("English", englishGrades);
        gradesBySubject.put("Programming", programmingGrades);
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Truneva Julia",
                gradesBySubject, 5, 5);
        Assertions.assertTrue(gradeBook.isEligibleForHonorsDegree());
    }

    @Test
    public void testNorEligibleForHonorsDegree() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(5, 3));
        gradesBySubject.put("English", Arrays.asList(5, 4));
        gradesBySubject.put("Programming", Arrays.asList(3, 3));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Pavlenko Stepan",
                gradesBySubject, 3, 3);
        Assertions.assertFalse(gradeBook.isEligibleForHonorsDegree());
    }

    @Test
    public void testIsEligibleForIncreasedScholarship() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(4, 4));
        gradesBySubject.put("English", Arrays.asList(4, 4));
        gradesBySubject.put("Programming", Arrays.asList(5, 5));
        ElectronicGradeBook gradeBook = new ElectronicGradeBook("Klushneva Liza",
                gradesBySubject, 5, 4);
        Assertions.assertTrue(gradeBook.isEligibleForIncreasedScholarship());
    }

    @Test
    public void testNotEligibleForIncreasedScholarship() {
        Map<String, List<Integer>> gradesBySubject = new HashMap<>();
        gradesBySubject.put("Math", Arrays.asList(4, 3));
        gradesBySubject.put("English", Arrays.asList(4, 3));
        gradesBySubject.put("Programming", Arrays.asList(4, 4));
        ElectronicGradeBook gradeBook =
                new ElectronicGradeBook("Begaykin Vyacheslav", gradesBySubject, 4, 5);

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
