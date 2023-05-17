package miningUniversity.Practice10;

public class Shop extends SmallBusiness {
    static private String[] names = {"SevenEleven", "Apteka.ru","Ariana Grande", "ShopDaniel", "Sephora", "Wahaha", "Vietnam", "Revolushen", "DotaPlus"};

    Shop(){
        super(names[(int) (Math.random() * names.length) + 0],(int) (Math.random() * 100));
    }

    @Override
    public String toString() {
        return "Shop{" +
                "value=" + getValue() +
                '}';
    }
}
