package Practice11;
public class Main {
    static SmallBusiness<String[]> obj1 = new SmallBusiness<>();
    static SmallBusiness<Integer[]> obj2 = new SmallBusiness<>();
    static String[] s1 = {"У ОЛЭСИ", "Чик-чик и готово", "Подстригу шо мама не узнает", "Vietnam", "Revolushen", "DotaPlus"};
    static Integer[] s2 = {76, 290, 21, 292, 1, 19};



    public static void main(String[] args) {
        obj1.s = s1;
        obj2.s = s2;
        newThread nt1 = new newThread("Побочный");
        try {
            System.out.println("Главный поток запущен");
            Thread.sleep(4000);
            countStaff(obj2.s, obj1.s);
            Thread.sleep(4000);
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван");
        }
        System.out.println("\nПoтoк "+ nt1.nаmе +" запущен:" + nt1.t.isAlive());
        System.out.println("Глaвный поток завершен.");
    }

    public static void countStaff(Integer[] countStaff, String[] name) {
        int CS = countStaff[0];
        String fname = name[0];
        for (int i = 1; i < countStaff.length; i++) {
            if(countStaff[i-1] > CS) fname = name[i-1];
        }
        System.out.println("Предприятие с наибольшим числом сотрудников: "+ fname);
    }

}

class newThread implements Runnable {
    String nаmе; // имя потока исполнения
    Thread t ;

    newThread(String threadname) {
        nаmе = threadname;
        t = new Thread(this, nаmе);
        System.out.println("Hoвый поток: " + t);
        t.start();    // запустить поток исполнения
    }
    public void run() {  // точка входа в поток исполнения
        try {
            SmallBusiness<Integer[]> obj3 = new SmallBusiness<>();
            Integer[] s3 = {32, 10, 2, 1, 27, 100};
            obj3.s = s3;
            int count = 0;
            for (int i = 0; i < s3.length; i++) {
                count = count + s3[i];
            }
            System.out.println("Число парикмахерских: " + count);
            Thread.sleep(2000);
        }
        catch(InterruptedException е) {
            System.out.println (nаmе + " прерван.");
        }
    }
}

class SmallBusiness <Type> {
    public Type s;
}
