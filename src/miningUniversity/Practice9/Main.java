package miningUniversity.Practice9;

class SmallBusiness <Type> {
    public Type s;
}
public class Main {
    public static void main(String[] args) {
        SmallBusiness<String[]> obj1 = new SmallBusiness<>();
        SmallBusiness<Integer[]> obj2 = new SmallBusiness<>();
        SmallBusiness<Integer[]> obj3 = new SmallBusiness<>();
        String[] s1 = {"У ОЛЭСИ", "Чик-чик и готово", "Подстригу шо мама не узнает", "Vietnam", "Revolushen", "DotaPlus"};
        Integer[] s2 = {76, 290, 21, 292, 1, 19};
        Integer[] s3 = {32, 10, 2, 1, 27, 100};
        obj1.s = s1;
        obj2.s = s2;
        obj3.s = s3;
        System.out.println("Предприятие с наибольшим числом сотрудников: "+ countStaff(obj2.s, obj1.s));
        System.out.println("Число парикмахерских: " + countBarberShop(obj3.s));
    }

    public static String countStaff(Integer[] countStaff, String[] name) {
        int CS = countStaff[0];
        String fname = name[0];
        for (int i = 1; i < countStaff.length; i++) {
            if(countStaff[i-1] > CS) fname = name[i-1];
        }
        return fname;
    }

    public static Integer countBarberShop(Integer[] obj) {
        int count = 0;
        for (int i = 0; i < obj.length; i++) {
            count = count + obj[i];
        }
        return count;
    }
}
