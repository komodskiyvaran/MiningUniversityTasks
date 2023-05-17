package miningUniversity.Exam1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String[]> globallist = new ArrayList<>();
    static long timeOnTest = 20 * 1000 * 60;
    static int attempt = 0;
    static String quesFile = "src\\MiningUniversity.Exam1\\voprosi.txt";
    static String ansFile = "src\\MiningUniversity.Exam1\\otveti.txt";
    static String resFile = "src\\MiningUniversity.Exam1\\resultati.txt";

    static {
        System.out.println("Аннотации в Java являются своего рода метками в коде,\n" +
                "описывающими метаданные для функции/класса/пакета.\n" +
                "Тест состоит из 20 вопросов. Данные о пройденном тесте хранятся в отдельном файле.\n" +
                "Ответ на вопрос - одна буква. Удачного тестирования.");
    }

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile(resFile, "rw")) {
            raf.setLength(0);
        }
        catch (IOException e) {
            System.out.println("Файл не найден");
        }

        String input;
        Boolean condition = true;

        while (condition) {
            System.out.println("\t\t1 - Задать время на тестирование. По умолчанию 20 минут. \n" +
                    "\t\t2 - Начать тестирование.\n" +
                    "\t\t3 - Посмотреть результаты тестирования.\n" +
                    "\t\t0 - Выход из программы.");
            System.out.print("Введите значение(0-3): ");
            input = scan.next();

            switch (input) {
                case "1":
                    TimeTest();
                    break;
                case "2":
                    TestStart();
                    break;
                case "3":
                    showResults();
                    break;
                case "0":
                    condition = false;
                default:
                    System.out.println("Введено неверное значение.");
                    break;
            }
        }
    }

    public static void TimeTest() {
        System.out.print("Введите новое значение времени в минутах: ");
        try {
            String newtime = scan.next();
            timeOnTest = Integer.parseInt(newtime) * 1000 * 60;
        } catch (Exception ex) {
            System.out.println("\nНеверный ввод, должно быть целое число минут.");
        }
    }

    public static void TestStart() {
        attempt++;
        String[] info = new String[7];
        info[0] = String.valueOf(attempt);
        info[1] = LocalDate.now().toString();
        System.out.print("Введите фамилию: ");
        info[2] = scan.next();
        System.out.print("Введите имя: ");
        info[3] = scan.next();

        String[] listQues = ReadFile(quesFile);
        String[] listAns = ReadFile(ansFile);

        int count = 0;
        String[] UserAns = new String[20];
        Date date = new Date();
        long startTime = date.getTime();

        test:
        for (int i = 0; i < listQues.length; ) {
                for (int o = 0; o < 20; o++) {
                System.out.println(listQues[i] + "\n" + listQues[i + 1] + "\n" + listQues[i + 2] + "\n" + listQues[i + 3] + "\n" + listQues[i + 4]);
                System.out.print(" Выберите верное: ");
                UserAns[o] = scan.next();

                if(UserAns[o].equals("a") || UserAns[o].equals("b") || UserAns[o].equals("c") || UserAns[o].equals("d")){
                    i+=5;
                    if (UserAns[o].equals(listAns[o])) count++;
                } else System.out.println("Введен недопустимый вариант.");

                if(Time(startTime)) continue;
                else break test;
                }
            }

        Date d = new Date();
        long totalTime = d.getTime() - startTime;
        String time = totalTime/60000+":"+(totalTime/1000)%60;
        info[4] = time;
        System.out.println("\n\nПотрачено времени: "+ time +"\nКоличество правильных ответов: "+count);
        info[5] = String.valueOf(count);
        int mark=2;
        if((double)count/20 >0.50){
            mark = 3;
            if((double)count/20 >=0.70){
                mark = 4;
                if((double)count/20 >=0.85){
                    mark = 5;
                }
            }
        }
        info[6] = String.valueOf(mark);
        System.out.println("Оценка: "+ mark);
        WriteInFile(info);
        globallist.add(info);
    }

    static Boolean Time(long startTime){
        Date q = new Date();
        long time = q.getTime();
        if ((time - startTime) < timeOnTest)
            return true;
        else{
            System.out.println("Время на тест вышло.");
            return false;
        }
    }

    static String[] ReadFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            list = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return list.toArray(new String[list.size()]);
    }

    public static void WriteInFile(String[] info) {
        try{
            FileWriter fileWriter = new FileWriter(resFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String out: info) {
                printWriter.print(out + "\t");
            }
            printWriter.println();
            printWriter.close();
        } catch (IOException ex){
            System.out.println("Файл не был найден.");
        }
        System.out.println("Данные были успешно занесены в файл.");
    }

    public static void showResults(){
        System.out.println("\n№:\tDate:\t\tSurname\tName:\tTime: Ans: Mark:");
        for (String[] info: globallist) {
            for (int i = 0; i < info.length; i++) {
                System.out.print(info[i]+ "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}