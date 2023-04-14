package Practice5;

class Barbershop extends SmallBusiness {
    private int countSeat;

    public Barbershop(String nameShop, int countStaff, int countSeat) {
        super(nameShop, countStaff);
        this.countSeat = countSeat;
    }
}
