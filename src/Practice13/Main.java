package Practice13;

import java.util.ArrayList;

@FunctionalInterface
interface CalcIndicator {
    String CalcIndicatorLambda(ArrayList<SmallBusiness> array);
}

public class Main {
    static ArrayList<SmallBusiness> shop = new ArrayList<>();
    static ArrayList<SmallBusiness> barber = new ArrayList<>();


    public static void main(String[] args) {
        createObject();
// ЭТО ДЛЯ ПЕРВОГО ЗАДАНИЯ
        CalcIndicator func = (ArrayList<SmallBusiness> arr) -> {
            String fname = arr.get(0).getName();
            int maxSfaff = arr.get(0).getCountStaff();
            for (SmallBusiness obj: arr) {
                if (obj.getCountStaff() >= maxSfaff) {
                    fname = obj.getName();
                    maxSfaff = obj.getCountStaff();
                }
            }
            return fname;
        };

        System.out.println(func.CalcIndicatorLambda(shop));

        //ЗАДАНИЕ2
        MyCalcCountStaffLink obj = new MyCalcCountStaffLink();
        /* Ссылка на метод экземпляра finName( ) передается методу obj( ) */
        System.out.println(stringLambdaFunLink(obj::finName, barber)); // передаем ссылку

    }

    static void createObject() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) barber.add(new BarberShop());
            else shop.add(new Shop());
        }

        shop.forEach( (s) -> System.out.println(s.show()));
        System.out.println();
        barber.forEach( (s) -> System.out.println(s.show()));
        System.out.println();
    }

    /* В этом методе функциональный интерфейс указывается в качестве типа
первого его параметра. Следовательно, ему может быть передан любой экземпляр
 этого интерфейса, включая и ссылку на метод*/
    static String stringLambdaFunLink(CalcIndicator cl, ArrayList<SmallBusiness> array){
        return cl.CalcIndicatorLambda(array);
    }

}

class MyCalcCountStaffLink{
    // определяется метод экземпляра finName()
    String finName(ArrayList<SmallBusiness> arr){
        String fname = arr.get(0).getName();
        int maxSfaff = arr.get(0).getCountStaff();
        for (SmallBusiness obj: arr) {
            if (obj.getCountStaff() >= maxSfaff) {
                fname = obj.getName();
                maxSfaff = obj.getCountStaff();
            }
        }
        return fname;
    }
}