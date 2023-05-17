package miningUniversity.Practice14;

public class BarberShop extends SmallBusiness {
    static private String[] names = {"hard coin", "KingsMan","ALIBABA", "NORD BARBERS", "Fly", "HairFcker", "L&L", "Chio Chio", "Hair Cut"};

    public BarberShop() {
        super(names[(int) (Math.random() * names.length) + 0],(int) (Math.random() * 100));
    }
}
