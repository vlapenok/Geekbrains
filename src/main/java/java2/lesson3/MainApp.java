package java2.lesson3;

import java.math.BigDecimal;

public class MainApp {
    public static void main(String[] args) {
        double a = 1.0;
        int b = 10;
        double x = a / b;

        BigDecimal big = new BigDecimal(x);

        System.out.println(big);
    }
}
