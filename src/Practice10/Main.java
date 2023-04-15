package Practice10;

import java.util.*;

public class Main {
    static final int NUMOBJECT = 100_000;
    static Scanner scanner = new Scanner(System.in);
    static List<SmallBusiness> arrayList = new ArrayList<>();
    static LinkedList<SmallBusiness> linkedList = new LinkedList<>();
    static long start;
    static long finish;


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Создание списка");
            System.out.println("2. Поиск элемента списка по значению параметра");
            System.out.println("3. Удаление объекта из списка с заданным параметром");
            System.out.println("4. Вычисление показателя");
            System.out.print("Введите число: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addObjectInList();
                    break;
                case 2:
                    elementSearch();
                    break;
                case 3:
                    delElement();
                    break;
                case 4:
                    CalcIndicator();
                    break;
                case 5:
                    printList();
                    break;
                case 6:
                    System.out.println("Выход из программы!");
                    break;
                default:
                    System.out.println("Неправильный выбор! Попробуйте еще раз.");
                    break;
            }
        } while (choice != 6);
    }
    static void addObjectInList(){
// ARRAYLIST
        start = System.currentTimeMillis();
        for (int i = 0; i < NUMOBJECT; i++)
            arrayList.add(new Shop());
        finish = System.currentTimeMillis();
        System.out.printf("\nНа заполнение ArrayList %d объектами ушло %d мс.\n", NUMOBJECT, (finish - start));
// LINKEDLIST
        start = System.currentTimeMillis();
        for (int i = 0; i < NUMOBJECT; i++)
            linkedList.add(new BarberShop());
        finish = System.currentTimeMillis();
        System.out.printf("На заполнение LinkedList %d объектами ушло %d мс.\n", NUMOBJECT, (finish - start));
    }

    static void elementSearch(){
        System.out.print("\nВведите значение параметра: ");
        int element = scanner.nextInt();
//ARRAYLIST
        start = System.currentTimeMillis();
        boolean resSearch = false;
        for (SmallBusiness o: arrayList)
            if(o.getValue() == element) resSearch = true;
        finish = System.currentTimeMillis();
        System.out.print(resSearch == false? "Элемент в ArrayList не был найден.    " : "Элемент в ArrayList был найден.    " );
        long f = finish - start;
        System.out.println("Время: " + f + " мс.");
//LINKEDLIST
        start = System.currentTimeMillis();
        resSearch = false;
        for (SmallBusiness o: linkedList)
            if(o.getValue() == element) resSearch = true;
        finish = System.currentTimeMillis();
        System.out.print(resSearch == false? "Элемент в LinkedList не был найден.    " : "Элемент в LinkedList был найден.    " );
        System.out.println("Время: " + (finish - start) + " мс.");
    }

    static void delElement(){
        System.out.print("\nВведите значение параметра для удаления: ");
        int deleteValue = scanner.nextInt();
// ARRAYLIST
        start = System.currentTimeMillis();
        boolean isDeleted = false;
        for (SmallBusiness list : arrayList) {
            if (list.getValue() == deleteValue) {
                arrayList.remove(list);
                isDeleted = true;
                break;
            }
        }
        System.out.print(isDeleted == true?"Объект удален из cписка ArrayList.  ":"Объект не найден в списке ArrayList. ");
        finish = System.currentTimeMillis();
        System.out.println("Время: " + (finish - start) + " мс.");

//LINKEDLIST
        start = System.currentTimeMillis();
        isDeleted = false;
        for (SmallBusiness list : linkedList) {
            if (list.getValue() == deleteValue) {
                linkedList.remove(list);
                isDeleted = true;
                break;
            }
        }
        System.out.print(isDeleted == true?"Объект удален из cписка LinkedList.  ":"Объект не найден в списке LinkedList. ");
        finish = System.currentTimeMillis();
        System.out.println("Время: " + (finish - start) + " мс.");
    }

    static void printList(){
        Iterator<SmallBusiness> iter = arrayList.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println("\nSIZE: " + arrayList.size());

        Iterator<SmallBusiness> iter1 = linkedList.iterator();
        while(iter1.hasNext()){
            System.out.print(iter1.next() + " ");
        }
        System.out.println("\nSIZE: " + linkedList.size());
    }

    private static void CalcIndicator() {
//ARRAYLIST
        int maxStaff = arrayList.get(0).getValue();
        String name = arrayList.get(0).getName();
        start = System.currentTimeMillis();
        for (SmallBusiness o: arrayList)
            if (o.getValue() > maxStaff) name = o.getName();
        finish = System.currentTimeMillis();
        System.out.printf("\n%s имеет наибольшее число сотрудников.   Время: %d мс.\n", name, (finish-start));
//LINKEDLIST
        maxStaff = linkedList.get(0).getValue();
        name = linkedList.get(0).getName();
        start = System.currentTimeMillis();
        for (SmallBusiness o: linkedList)
            if (o.getValue() > maxStaff) name = o.getName();
        finish = System.currentTimeMillis();
        System.out.printf("%s имеет наибольшее число сотрудников.   Время: %d мс.\n", name, (finish-start));

    }
}

