package miningUniversity.Practice7;

import java.util.Scanner;

public class TestClass {
    static Scanner scanner = new Scanner(System.in);
    static{
        System.out.println("Практика #6 - noname - Вариант #3");
    }

    {
        System.out.println( "\t\t\t Меню действий: \n" +
                "\t\t1 - Отобразить свойства объектов \n" +
                "\t\t2 - Изменить свойства объекта \n" +
                "\t\t3 - Вычислить, какое предприятие имеет наибольшее число сотрудников \n" +
                "\t\t0 - Выход из программы");
    }


    public static void main(String[] args) {

        TestClass testclass = new TestClass();
        Barbershop barbershop = new Barbershop(0, "Парикхмахерская у Олэси", 7, 4);
        Barbershop barbershop1 = new Barbershop(1, "Человейник в человеке", 3, 39);
        Shop shop = new Shop(2, "ProstoApteka", 42, "Аптека");
        Shop shop1 = new Shop(3,"H&M", 59, "Продуктовый");


        int input = scanner.nextInt();
        while (input != 0){
            switch (input){
                case 1:
                    barbershop.showSmallBusiness();
                    barbershop1.showSmallBusiness();
                    shop.showSmallBusiness();
                    shop1.showSmallBusiness();
                    break;
                case 2:
                    testclass.ref(barbershop, barbershop1, shop, shop1);
                    break;
                case 3:
                    barbershop.calcIndicator(barbershop, barbershop1, shop, shop1);
                    break;
                default:
                    break;
            }
            System.out.print("Введите цифру действия (0-3): ");
            input = scanner.nextInt();
        }

    }


    public void ref(Barbershop one, Barbershop two, Shop three, Shop four) {
        System.out.print("Выберите ID объекта, у которого хотите заменить данные: ");
        int idObj = scanner.nextInt();
        switch (idObj){
            case 0:
                one.refactor();
                break;
            case 1:
                two.refactor();
                break;
            case 2:
                three.refactor();
                break;
            case 3:
                four.refactor();
                break;
        }
        System.out.println("Ввод данных успешно завершен.");
    }
}
