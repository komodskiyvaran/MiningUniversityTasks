package miningUniversity.Practice3;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int x = scanner.nextInt();
            System.out.println(284 / x);
        } catch (ArithmeticException e) {
            System.out.println("division by zero");
        }
    }
}
