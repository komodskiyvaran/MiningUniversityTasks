package miningUniversity.Practice4;

import java.util.Scanner;

public class FileManager {
    static String CHANGE = "1 - Выбор каталога \n" +
            "2 - Вывод содержимого каталога \n" +
            "3 - Вывод свойств выбранного файла \n" +
            "4 - Удаление выбранного файла \n" +
            "5 - Создание текстого файла \n" +
            "6 - Создание нового каталога \n" +
            "7 - Чтение содержимого файла \n" +
            "0 - Выход из программы";


    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);  // Сканнер
        String directoryName = "none";

        Manager filemanager = new Manager();
        System.out.println(CHANGE);
        int input = scan.nextInt();

        while (input != 0) {
            System.out.println("Изначальный путь: " + directoryName);
            switch (input){
                case 1:
                    directoryName = filemanager.Choice();
                    break;
                case 2:
                    filemanager.listOfFiles(directoryName);
                    break;
                case 3:
                    filemanager.quality(directoryName);
                    break;
                case 4:
                    filemanager.del();
                    break;
                case 5:
                    filemanager.createFile(directoryName);
                    break;
                case 6:
                    filemanager.createDir(directoryName);
                    break;
                case 7:
                    filemanager.Open();
                    break;
                default:
                    break;
            }
            System.out.println("\nВведите число");
            input = scan.nextInt();
        }
    }
}