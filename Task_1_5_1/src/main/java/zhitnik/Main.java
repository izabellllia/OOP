package zhitnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("write -1 to exit");
        while (true){
            String formula = reader.readLine();
            if(formula.equals("-1")){
                break;
            }
            else {
                System.out.println(calculate(formula));
            }
        }
    }
    public static Double calculate(String formula) {
        MyCalculator calculator = new MyCalculator();
        return calculator.calc(formula);
    }
}