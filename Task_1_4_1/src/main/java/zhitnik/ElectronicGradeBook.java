package zhitnik;

/**Класс-электронный журнал оценок студентов.*/
public class ElectronicGradeBook {
    private String studentName;
    private double[] grades;
    private double finalExamGrade;
    private double qualificationWorkGrade;

    /**Конструктор принимает 4 аргумента, используется для
     * инициализации экземпляра класса с этими значениями.*/
    public ElectronicGradeBook(String studentName,
                               double[] grades, double finalExamGrade,
                               double qualificationWorkGrade) {
        this.studentName = studentName;
        this.grades = grades;
        this.finalExamGrade = finalExamGrade;
        this.qualificationWorkGrade = qualificationWorkGrade;
    }

    /**Вычисляется средний балл.*/
    public double calculateOverallGpa() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    /**Проверяет возможность получения красного диплома,
     * большинство оценок (как минимум 75%) должны быть равны 5.0,
     * а также оценка за финальный экзамен и квалификационную работу
     * также должны быть равны 5.0. Если условия выполняются,
     * метод возвращает true, иначе - false.*/
    public boolean isEligibleForHonorsDegree() {
        int excellentGradesCount = 0;
        for (double grade : grades) {
            if (grade == 5.0) {
                excellentGradesCount++;
            }
        }
        return excellentGradesCount >= grades.length * 0.75 &&
                finalExamGrade == 5.0 &&
                qualificationWorkGrade == 5.0;
    }

    /**Проверка на возможность получения стипендии,
     * для этого все оценки студента должны быть не ниже 4.0.
     * Если условие выполняется, метод возвращает true,
     * если хотя бы одна оценка ниже 4.0, метод возвращает false.*/
    public boolean isEligibleForIncreasedScholarship() {
        for (double grade : grades) {
            if (grade < 4.0) {
                return false;
            }
        }
        return true;
    }
}

