package Practice13;

public class SmallBusiness {

    private String nameShop;
    private int countStaff;

    public SmallBusiness(String nameShop, int countStaff) {
        this.nameShop = nameShop;
        this.countStaff = countStaff;
    }

    public void setName(String nameShop) { // Метод установки имени объекта
        this.nameShop = nameShop;
    }

    public void setCountStaff(int countStaff) {  // Метод установки количества сотрудников
        this.countStaff = countStaff;
    }

    public int getCountStaff(){ // метод для получения информации о количестве сотруднико
        return countStaff;
    }

    public String getName(){ // метод для получения информации о наименовании организации
        return nameShop;
    }

    public String show() {
        return getName() + "\t\t EMPLOYEE: " + getCountStaff();
    }
}
