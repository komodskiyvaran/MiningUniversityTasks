package miningUniversity.Practice6;

class Barbershop extends SmallBusiness {
    static private String[] names = {"hard coin", "KingsMan","ALIBABA", "NORD BARBERS", "ФЕЯ", "HairFcker", "L&L", "Чио Чио", "Подстригу как надо"};
    private int seats;

    public Barbershop(int ID, String nameShop, int countStaff, int seats) {
        super(ID, nameShop, countStaff);
        this.seats = seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void showSmallBusiness() {
        System.out.println(getID() + ":  " + getNameShop() + "\t\t EMPLOYEE: " + getCountStaff() + "\t\t SEATS: " + getSeats());
    }  // Метод вывода данных объекта этого класса

    public void refactor() {
        super.refactor();
        setNameShop(names[(int) (Math.random() * names.length) + 0]);
        setSeats((int) (Math.random() * 55) + 0);
    }
}
