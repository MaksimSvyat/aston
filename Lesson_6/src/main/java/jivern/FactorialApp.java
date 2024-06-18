package jivern;

import java.util.Scanner;

public class FactorialApp {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        long factorial = 1L;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Факториал числа " + n + " равен " + factorial);
        scanner.close();
    }
}
