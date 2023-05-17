package miningUniversity.Practice4;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
    static Scanner scanner = new Scanner(System.in);

    public Manager() {
    }

    public String Choice() {
        System.out.println("Укажите путь: ");
        return scanner.nextLine();
    }

    public void listOfFiles(String way) {
        System.out.println("Содержимое каталога: ");
        File currentFolderAsFile = new File(way);
        File files[] = currentFolderAsFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName() + "\tкаталог");
            } else {
                System.out.println(file.getName() + "\tфайл");
            }
        }
    }


    public void quality(String way) { // кем ты себя возомнил, файлик?
        File fl = new File(way);
        System.out.println("Имя файла : " + fl.getName() +
                "\nПуть : " + fl.getPath() +
                "\nАбсолютный путь : " + fl.getAbsolutePath() +
                "\nРодительский каталог : " + fl.getParent());
        System.out.println(fl.exists() ? "Существует " : "Не существует ");
        System.out.println(fl.canWrite() ? "Доступен для записи" : "Не доступен для записи");
        System.out.println(fl.canRead() ? "Доступен для чтения " : "Не доступен для чтения ");
        System.out.println(fl.isDirectory() ? "Является каталогом" : "Не является каталогом");
        System.out.println(fl.isFile() ? "Является обычным файлом " : "Может быть именованным каналом");
        System.out.println(fl.isAbsolute() ? "Является абсолютным" : "Не является абсолютным");
        System.out.println("Последнее изменение в файле:" + fl.lastModified());
        System.out.println("Размер : " + fl.length() + " байт ");
    }

    public void del() {
        System.out.println("Укажите путь к файлу/каталогу который хотите удалить: ");
        String way = scanner.nextLine();
        File newDir = new File(way);
        boolean deleted = newDir.delete();
        if (deleted)
            System.out.println("Каталог удален.");
        else System.out.println("Ошибка, файл не был удалён.");
    }

    public void createFile(String way) {
        try {
            System.out.println("Введите название файла с расширением .txt, чтобы создать его:");
            String create = scanner.nextLine();
            File f = new File(way + "\\" + create);
            if (f.createNewFile())
                System.out.println("Файл создан.");
            else
                System.out.println("Не получилось создать файл.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void createDir(String way) {
        System.out.println("Введите название папки, чтобы создать её:");
        String create = scanner.nextLine();
        File dir = new File(way + "\\" + create);
        boolean created = dir.mkdir();
        if (created)
            System.out.println("Каталог успешно создан.");
        else System.out.println("Каталог не был создан.");
    }

    public void Open() {
        System.out.println("Введите полный путь файла, который хотите открыть");
        File file = new File(scanner.nextLine());
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
