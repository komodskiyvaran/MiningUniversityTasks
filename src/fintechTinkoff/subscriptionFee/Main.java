package fintechTinkoff.subscriptionFee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] numbers = input.split(" ");

        int costOfTariff = Integer.parseInt(numbers[0]); // стоимость тарифа
        int tariffSizeMB = Integer.parseInt(numbers[1]); // размер тарифа
        int costOfEachExtraBM = Integer.parseInt(numbers[2]); // стоимость каждого лишнего гб
        int expenditureMB = Integer.parseInt(numbers[3]);     // расход в этом мес€це

        if (expenditureMB <= tariffSizeMB) System.out.print(costOfTariff);
        else System.out.print(costOfTariff + costOfEachExtraBM * (expenditureMB - tariffSizeMB));
    }
}
