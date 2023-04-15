package Practice10;

public class BarberShop extends SmallBusiness {
    static private String[] names = {"hard coin", "KingsMan","ALIBABA", "NORD BARBERS", "ФЕЯ", "HairFcker", "L&L", "Чио Чио", "Подстригу как надо"};

    public BarberShop(){
        super(names[(int) (Math.random() * names.length) + 0],(int) (Math.random() * 100));
    }


    @Override
    public String toString() {
        return "Shop{" +
                "value=" + getValue() +
                '}';
    }
}
