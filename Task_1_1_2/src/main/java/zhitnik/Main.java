package zhitnik;

/**класс Polinom.*/
public class Main{

    /**Polinom.*/
    public static void Main(String[] args) {
        Polinom p1 = new Polinom(new int[] {4, 3, 6, 7});
        Polinom p2 = new Polinom(new int[] {3, 2, 8});
        System.out.println(p1.plus(p2.differentiate(1)).toString());
        System.out.println(p1.times(p2).evaluate(2));
    }
}
