package fintechTinkoff.coinsOfThreeDenominations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int one, two, three;
        one = scan.nextInt();
        two = scan.nextInt();
        three = scan.nextInt();

        int count = 0;

        for (int a = 0; one * a < sum + 1; a++) {
            if (1 + one * a <= sum) count ++;
            for (int b = 0; two * b < sum + 1; b++) {
                if (1 + one * a + two * b <= sum & b != 0 & one != two) count ++;
                for (int c = 1; three * c < sum + 1 ; c++) {
                    if (1 + one * a + two * b + three * c < sum + 1  & one != two & two != three) count ++;
                }
            }
        }
        System.out.print(count);
    }
}