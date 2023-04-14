package Practice3;

import java.util.Scanner;

public class TaskTwo {
    public static String[] numbers = new String[3];
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args){
        try {
            enterArray();
        } catch(ArrayIndexOutOfBoundsException bound){
            System.out.println(bound.getMessage());
        }
    }


    public static void enterArray() throws ArrayIndexOutOfBoundsException {
        System.out.println("Введите элементы массива, размерносью 3: ");
        String value = scan.nextLine();
        String[] values = value.split(" ");
        if (values.length == numbers.length){
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = values[i];
            }
            System.out.println("Ввод массива успешно завершен.");
        }
        else
            throw new ArrayIndexOutOfBoundsException("Exception: Выход за границы массива!");
    }
}
