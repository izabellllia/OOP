package zhitnik;

/**Метод, проверяющий является ли
 * указанное целое число number простым.
 */
public class IsPrime {
    /**check  if the number is prime.*/
    public static boolean isPrimeMethod(int number) {
        if (number <= 1) {
            return false;
        }
        double sqrtNum = Math.sqrt(number);
        for (int i = 2; i <= sqrtNum; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}