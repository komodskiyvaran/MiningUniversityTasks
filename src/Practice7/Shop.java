package Practice7;

class Shop extends SmallBusiness {
    static private String[] names = {"SevenEleven", "Apteka.ru","Ariana Grande", "ShopDaniel", "Sephora", "Wahaha", "Vietnam", "Revolushen", "DotaPlus"};
    static private String[] types = {"Аптека", "Продуктовый", "Торговый центр", "Магазин одежды", "Магазин косметики", "Магазин кастомных товаров"};
    private String type;

    public Shop(int ID, String nameShop, int countStaff, String type) {
        super(ID, nameShop, countStaff);
        this.type = type;
    }

    public void setType(String type){      // Установка типа объекта
        this.type = type;
    }

    public String getType() {           // Получение типа объекта
        return type;
    }

    public void showSmallBusiness() {
        System.out.println(getID() + ":  " + getNameShop() + "\t\t EMPLOYEE: " + getCountStaff() + "\t\t TYPESHOP: " + getType());
    }

    public void refactor() {
        super.refactor();
        setNameShop(names[(int) (Math.random() * types.length) + 0]);
        setType(types[(int) (Math.random() * types.length) + 0]);
    }
}
