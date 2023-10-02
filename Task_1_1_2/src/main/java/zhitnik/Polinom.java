package zhitnik;

import java.util.Arrays;

/**класс Polinom.*/
public class Polinom {
    private int degree;
    private int[] coefficients;
    /**Конструктор принимает массив целых чисел coefficients и инициализирует
     * переменные degree и coefficients.*/

    public Polinom(int[] coefficients) {
        this.degree = coefficients.length - 1;
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }
    /**Метод plus, принимает другой полином в качестве аргумента и возвращает
     *новый полином, являющийся суммой текущего
     * полинома и переданного полинома.*/

    public Polinom plus(Polinom other) {
        int maxDegree = Math.max(this.degree, other.degree);
        int[] resultCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }
        for (int i = 0; i <= other.degree; i++) {
            resultCoefficients[i] += other.coefficients[i];
        }
        return new Polinom(resultCoefficients);
    }

    /**Метод minus аналогично plus, принимает другой полином в
     * качестве аргумента и возвращает новый полином, являющийся
     * суммой текущего полинома и переданного полинома.*/
    public Polinom minus(Polinom other) {
        int maxDegree = Math.max(this.degree, other.degree);
        int[] resultCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= this.degree; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }

        for (int i = 0; i <= other.degree; i++) {
            resultCoefficients[i] -= other.coefficients[i];
        }
        return new Polinom(resultCoefficients);
    }

    /**Таким образом, метод times выполняет умножение
     * двух полиномов, создает новый полином с
     * полученными коэффициентами и возвращает его.*/
    public Polinom times(Polinom other) {
        int resultDegree = this.degree + other.degree;
        int[] resultCoefficients = new int[resultDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                int index = i + j;
                resultCoefficients[index] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Polinom(resultCoefficients);
    }

    /**Метод принимает на вход целочисленный аргумент times, который указывает,
     * сколько раз нужно продифференцировать объект типа Polinom.*/
    public Polinom differentiate(int times) {
        Polinom result = this;

        for (int i = 0; i < times; i++) {
            int[] resultCoefficients = new int[result.degree];
            for (int j = 0; j < result.degree; j++) {
                resultCoefficients[j] = result.coefficients[j + 1] * (j + 1);
            }
            result = new Polinom(resultCoefficients);
        }
        return result;
    }

    /**используется для сравнения двух объектов типа Polinom.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Polinom other = (Polinom) obj;
        if (this.degree != other.degree) {
            return false;
        }
        for (int i = 0; i <= this.degree; i++) {
            if (this.coefficients[i] != other.coefficients[i]) {
                return false;
            }
        }
        return true;
    }
    /**Если ни одно из условий выше не выполняется, то метод возвращает true,
     что означает, что объекты равны.*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = this.degree; i >= 0; i--) {
            if (this.coefficients[i] != 0) {

                if (i != this.degree) {
                    sb.append(" + ");
                }
                sb.append(this.coefficients[i]);

                if (i > 0) {
                    sb.append("x");

                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**коэффициенты.*/
    public int[] getCoefficients() {
        return coefficients;
    }

    /**оценка.*/
    public int evaluate(int x) {
        int result = 0;
        int power = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, power);
            power++;
        }
        return result;
    }
}
