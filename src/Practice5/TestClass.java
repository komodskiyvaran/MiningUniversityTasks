package Practice5;

public class TestClass {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop("Парикхмахерская у Олэси", 7, 5);
        Shop shop = new Shop("Gloria Jeans", 42, "Магазин одежды");
        System.out.println(barbershop.calcIndicator(barbershop, shop));
    }
}