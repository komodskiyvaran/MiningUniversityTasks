package miningUniversity.Practice12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Retention(RetentionPolicy.RUNTIME)
@interface NaSanya {
    String str();
}

public class SmallBusiness {
    List<BarberShop> barber = new ArrayList<>();
    List<Shop> shop = new ArrayList<>();
    String[] names1 = {"SevenEleven", "Apteka.ru","Ariana Grande", "ShopDaniel", "Sephora", "Wahaha", "Vietnam", "Revolushen", "DotaPlus"};
    String[] names2 = {"hard coin", "KingsMan","ALIBABA", "NORD BARBERS", "ФЕЯ", "HairFcker", "L&L", "Чио Чио", "Подстригу как надо"};

    void start(){
        createObject();
        CalcIndic();
        barber.get(0).annoTest();
        shop.get(0).annoTest();
    }

    void createObject(){
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) barber.add(new BarberShop(names2[(int) (Math.random() * names2.length) + 0], (int) (Math.random() * 1000)));
            else shop.add(new Shop(names1[(int) (Math.random() * names1.length) + 0], (int) (Math.random() * 1000)));
        }

        for (BarberShop o: barber) {
            System.out.println(o.getName() + "   " + o.getCountStaff());
        }
        System.out.println();

        for (Shop o: shop) {
            System.out.println(o.getName() + "   " + o.getCountStaff());
        }
        System.out.println();
    }

    void CalcIndic(){
        int maxStaff = barber.get(0).getCountStaff();
        String finalname = barber.get(0).getName();
        for (BarberShop obj: barber) {
            if (obj.getCountStaff() >= maxStaff) {
                finalname = obj.getName();
                maxStaff = obj.getCountStaff();
            }
        }
        System.out.println("Среди объектов класса BarberShop предприятие с наиб числом сотрудников - "+ finalname);

        maxStaff = shop.get(0).getCountStaff();
        finalname = shop.get(0).getName();
        for (Shop obj: shop) {
            if (obj.getCountStaff() >= maxStaff) {
                finalname = obj.getName();
                maxStaff = obj.getCountStaff();
            }
        }
        System.out.println("Среди объектов класса Shop предприятие с наиб числом сотрудников - "+ finalname + "\n");
    }

    class BarberShop {
        String name;
        int countStaff;

        BarberShop(String name, int countStaff){
            this.name = name;
            this.countStaff = countStaff;
        }

        public String getName(){return name;}

        public Integer getCountStaff(){return countStaff;}

        // Аннотирование метода
        @NaSanya(str = "Тестовый метод вложенного класса BarberShop")
        public void annoTest(){
            BarberShop bs = new BarberShop(" ", 0);
            try {
// Получим Class созданного объекта
                Class c = bs.getClass();
// Получим объект Method, представляющий этот метод
                Method m = c.getMethod("annoTest");
// получение аннотации класса
                NaSanya anno = m.getAnnotation(NaSanya.class);
// вывод аннотации
                System.out.println("Аннотация метода: " + anno.str());
            } catch (NoSuchMethodException exc) {
                System.out.println("Метод ненайден");
            }
        }
    }

    class Shop {
        String name;
        int countStaff;

        Shop(String name, int countStaff) {
            this.name = name;
            this.countStaff = countStaff;
        }

        public String getName() { return name; }

        public Integer getCountStaff() { return countStaff; }


        @NaSanya(str = "Тестовый метод вложенного класса Shop")
        public void annoTest(){
            Shop bs = new Shop(" ", 0);
            try {
// Получим Class созданного объекта
                Class c = bs.getClass();
// Получим объект Method, представляющий этот метод
                Method m = c.getMethod("annoTest");
// получение аннотации класса
                NaSanya anno = m.getAnnotation(NaSanya.class);
// вывод аннотации
                System.out.println("Аннотация метода: " + anno.str());
            } catch (NoSuchMethodException exc) {
                System.out.println("Метод ненайден");
            }
        }
    }
}

class LocalInnerClass {
    public static void main(String[] args) {
        SmallBusiness SmBis = new SmallBusiness();
        SmBis.start();
    }
}