package Practice3;

import java.util.Scanner;

public class TaskThree {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        char a = scanner.next().charAt(0);
        char b = scanner.next().charAt(0);

        String codeA = Integer.toBinaryString(a);
        String codeB = Integer.toBinaryString(b);

        // Сдвиг влево двоичного кода строчной буквы     10 1101 -> 1101 10
        String two = codeA.substring(0, 2);
        String one = codeA.substring(2);
        String resA = one + two;
        System.out.println("Двоичный код строчной буквы: " + codeA);
        System.out.println("Сдвинутый двоичный код: "+ resA);



        // Сдвиг вправо двоичного кода заглавной буквы   1000 1 -> 1 1000
        String on = codeB.substring(codeB.length()-1);
        String tw = codeB.substring(0, codeB.length()-1);
        String resB = on + tw;
        System.out.println("Двоичный код заглавной буквы: " + codeB);
        System.out.println("Сдвинутый двоичный код: "+ resB);

        // Преобразование в 10 систему счисление получившийся сдвинутый двоичный код
        int k = Integer.parseInt(resB, 2);
        int i = Integer.parseInt(resA, 2);

        try{
            compute(i);
            compute(k);
        } catch (MyException е) {
            System.out.println( "Пepexвaчeнo исключение:" + е);
        }
    }

    static void compute (int oi) throws MyException {
        System.out.println("Bызвaн метод compute("+oi+")");
        if (oi < 21 || oi >100) {
            throw new MyException(oi);
        }
        System.out.println("Hopмaльнoe завершение");
    }
}

class MyException extends Exception {
    public int detail;

    MyException (int а) {
        detail = а;
    }
    public String toString() {
        return "Practice3.MyException [" + detail + "]";
    }
}

