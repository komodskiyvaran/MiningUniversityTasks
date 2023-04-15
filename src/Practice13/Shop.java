package Practice13;

public class Shop extends SmallBusiness{
    static String[] names = {"SevenEleven", "Apteka.ru","Ariana Grande", "ShopDaniel", "Sephora", "Wahaha", "Vietnam", "Revolushen", "DotaPlus"};

    public Shop() { // конструктор с обращением к конструктору класса SmallBusiness
        super(names[(int) (Math.random() * names.length) + 0],(int) (Math.random() * 100));
    }
}
