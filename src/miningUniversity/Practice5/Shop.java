package miningUniversity.Practice5;

class Shop extends SmallBusiness {
    private String type;

    public Shop(String nameShop, int countStaff, String type) {
        super(nameShop, countStaff);
        this.type = type;
    }
}
