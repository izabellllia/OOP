package zhitnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if (gradesBySubject.containsKey(subject)) {
            gradesBySubject.get(subject).add(grade);
        } else {
            List<Integer> grades = new ArrayList<>();
            grades.add(grade);
            gradesBySubject.put(subject, grades);
        }
    }

    /**Возвращает список оценок по определенному предмету.*/
    public List<Integer> getGradesForSubject(String subject) {
        return gradesBySubject.get(subject);
    }


    /**Рассчитывает общий средний балл путем суммирования
     * всех оценок и деления на общее количество оценок.*/
    public double calculateOverallGpa() {
        double sum = 0;
        int count = 0;
        for (List<Integer> subjectGrades : gradesBySubject.values()) {
            for (int grade : subjectGrades) {
                sum += grade;
                count++;
            }
        }
        return sum / count;
    }

    /**Проверяет, имеет ли студент достаточно отличных оценок,
     * высоких оценок за выпускной экзамен и квалификационную
     * работу, чтобы иметь право на получение степени с отличием.*/
    public boolean isEligibleForHonorsDegree() {
        int excellentGradesCount = 0;
        for (List<Integer> subjectGrades : gradesBySubject.values()) {
            for (int grade : subjectGrades) {
                if (grade == 5) {
                    excellentGradesCount++;
                }
            }
        }
        return excellentGradesCount >= calculateOverallGpa() * 0.75
                && finalExamGrade == 5
                && qualificationWorkGrade == 5;
    }

    /**Проверяет, нет ли у учащегося оценок ниже 4,
     * что дает ему право на повышенную стипендию.*/
    public boolean isEligibleForIncreasedScholarship() {
        for (List<Integer> subjectGrades : gradesBySubject.values()) {
            for (int grade : subjectGrades) {
                if (grade < 4) {
                    return false;
                }
            }
        }
        return true;
    }
}
