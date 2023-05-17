package miningUniversity.Practice6;

import java.util.Scanner;

 class TestClass {
    static Scanner scanner = new Scanner(System.in);
    static{
        System.out.println("Практика #6 - noname - Вариант #3");
    }
    {
        System.out.println( "\t\t\t Меню действий: \n" +
                "\t\t1 - Отобразить свойства объектов \n" +
                "\t\t2 - Изменить свойства объекта \n" +
                "\t\t3 - Вычислить, какое предприятие имеет наибольшее число сотрудников \n" +
                "\t\t0 - Выход из программы\n");
    }

    public static void main(String[] args) {
        TestClass tk = new TestClass();
        Barbershop barbershop = new Barbershop(25, "Парикхмахерская у Олэси", 7, 4);
        Barbershop barbershop1 = new Barbershop(9, "Человейник в человеке", 3, 39);
        Shop shop = new Shop(22, "ProstoApteka", 42, "Аптека");
        Shop shop1 = new Shop(38,"H&M", 59, "Продуктовый");
        Shop shop2 = new Shop(81,"Euphoria", 3, "Чайхана");


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
                    tk.ref(barbershop, barbershop1, shop, shop1, shop2);
                    break;
                case 3:
                    barbershop.calcIndicator(barbershop, barbershop1, shop, shop1, shop2);
                    System.out.println();
                    break;
                default:
                    break;
            }
            System.out.print("Введите цифру действия (0-3): ");
            input = scanner.nextInt();
        }
    }

    public void ref(SmallBusiness one, SmallBusiness two, SmallBusiness three, SmallBusiness four, SmallBusiness five) {
        System.out.print("Выберите ID объекта, у которого хотите заменить данные: ");
        int idObj = scanner.nextInt();
        if (idObj == one.getID()) one.refactor();
        else if (idObj == two.getID()) two.refactor();
        else if (idObj == three.getID()) three.refactor();
        else if (idObj == four.getID()) four.refactor();
        else if (idObj == five.getID()) five.refactor();
        else {
            System.out.println("Неправильно выбран ID.");
        }
        System.out.println("Ввод данных успешно завершен.");
    }
}

