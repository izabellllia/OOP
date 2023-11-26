package zhitnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**Класс-электронный журнал оценок студентов.*/
public class ElectronicGradeBook {
    private String studentName;
    private Map<String, List<Integer>> gradesBySubject;
    private int finalExamGrade;
    private int qualificationWorkGrade;

    /**Инициализирует имя учащегося, оценки
     * по предмету, оценку итогового экзамена
     * и оценку квалификационной работы.*/
    public ElectronicGradeBook(String studentName,
                               Map<String, List<Integer>> gradesBySubject,
                               int finalExamGrade,
                               int qualificationWorkGrade) {
        this.studentName = studentName;
        this.gradesBySubject = gradesBySubject;
        this.finalExamGrade = finalExamGrade;
        this.qualificationWorkGrade = qualificationWorkGrade;
    }

    /**Добавляет оценку на карту оценок по предметам.*/
    public void addGrade(String subject, int grade) {
        gradesBySubject.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);
    }

    /**Возвращает список оценок по определенному предмету.*/
    public List<Integer> getGradesForSubject(String subject) {
        return gradesBySubject.get(subject);
    }

    /**Рассчитывает общий средний балл путем суммирования
     * всех оценок и деления на общее количество оценок.*/
    public double calculateOverallGpa() {
        return gradesBySubject.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    /**Проверяет, имеет ли студент достаточно отличных оценок,
     * высоких оценок за выпускной экзамен и квалификационную
     * работу, чтобы иметь право на получение степени с отличием.*/
    public boolean isEligibleForHonorsDegree() {
        long excellentGradesCount = gradesBySubject.values().stream()
                .filter(subjectGrades -> !subjectGrades.isEmpty() && subjectGrades.get(subjectGrades.size() - 1) == 5)
                .count();
        return excellentGradesCount >= 0.75 * gradesBySubject.size()
                && finalExamGrade == 5
                && qualificationWorkGrade == 5;
    }

    /**Проверяет, нет ли у учащегося оценок ниже 4,
     * что дает ему право на повышенную стипендию.*/
    public boolean isEligibleForIncreasedScholarship() {
        return gradesBySubject.values().stream()
                .allMatch(subjectGrades -> subjectGrades.get(subjectGrades.size() - 1) >= 4);
    }
}