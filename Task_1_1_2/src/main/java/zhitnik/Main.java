package zhitnik;
/**Объявление класса Main, который представляет полином.*/
import java.lang.Math;
public class Main{
    private int degree; //степень полинома
    private int[] coefficients; //коэф полинома
    /**Конструктор принимает массив целых чисел coefficients и инициализирует переменные degree и coefficients.*/
    public Main(int[] coefficients) {
        this.degree = coefficients.length - 1;
        this.coefficients = new int[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }
    /**Метод plus, принимает другой полином в качестве аргумента и возвращает
     *новый полином, являющийся суммой текущего полинома и переданного полинома.*/
    public Main plus(Main other) {
        int maxDegree = Math.max(this.degree, other.degree);
        int[] resultCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }
        for (int i = 0; i <= other.degree; i++) {
            resultCoefficients[i] += other.coefficients[i];
        }
        return new Main(resultCoefficients);
    }

    /**Метод minus аналогично plus, принимает другой полином в качестве аргумента и возвращает
     *новый полином, являющийся суммой текущего полинома и переданного полинома.*/
    public Main minus(Main other) {
        int maxDegree = Math.max(this.degree, other.degree);
        int[] resultCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            resultCoefficients[i] += this.coefficients[i];
        }
        for (int i = 0; i <= other.degree; i++) {
            resultCoefficients[i] -= other.coefficients[i];
        }
        return new Main(resultCoefficients);
    }

    /**Таким образом, метод times выполняет умножение двух полиномов, создает новый полином с
     * полученными коэффициентами и возвращает его*/
    public Main times(Main other) {
        int resultDegree = this.degree + other.degree;
        int[] resultCoefficients = new int[resultDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                int index = i + j;
                resultCoefficients[index] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Main(resultCoefficients);
    }
    /**Mетод evaluate используется для вычисления значения полинома для заданного значения x.*/
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i <= this.degree; i++) {
            result += this.coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**Метод принимает на вход целочисленный аргумент times, который указывает,
     * сколько раз нужно продифференцировать объект типа Main.*/
    public Main differentiate(int times) {
        Main result = this;
        for (int i = 0; i < times; i++) {
            int[] resultCoefficients = new int[result.degree];
            for (int j = 0; j < result.degree; j++) {
                resultCoefficients[j] = result.coefficients[j + 1] * (j + 1);
            }
            result = new Main(resultCoefficients);
        }
        return result;
    }

    /**используется для сравнения двух объектов типа Main.*/
    public boolean equals(Main other) {
        if (this.degree != other.degree) {
            return false;
        }
        for (int i = 0; i <= this.degree; i++) {
            if (this.coefficients[i] != other.coefficients[i]) {
                return false;
            }
        }
        return true;
    } /**Если ни одно из условий выше не выполняется, то метод возвращает true, что означает, что объекты равны.*/

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
    public static void main(String[] args) {
        Main p1 = new Main(new int[] {4, 3, 6, 7});
        Main p2 = new Main(new int[] {3, 2, 8});
        System.out.println(p1.plus(p2.differentiate(1)).toString());
        System.out.println(p1.times(p2).evaluate(2));
    }

    public int[] getCoefficients() {
        return coefficients;
    }
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