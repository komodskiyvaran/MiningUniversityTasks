package Practice6;


class SmallBusiness {
    private int ID;
    private String nameShop;
    private int countStaff;

    public SmallBusiness(int ID, String nameShop, int countStaff) {
        this.ID = ID;
        this.nameShop = nameShop;
        this.countStaff = countStaff;
    }

    public void setNameShop(String nameShop) { // Метод установки имени объекта
        this.nameShop = nameShop;
    }

    public void setCountStaff(int countStaff) {  // Метод установки количества сотрудников
        this.countStaff = countStaff;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCountStaff(){ // метод для получения информации о количестве сотруднико
        return countStaff;
    }

    public String getNameShop(){ // метод для получения информации о наименовании организации
        return nameShop;
    }

    public int getID(){     // метод для получения ID
        return ID;
    }

    public void refactor() {
        setID((int) (Math.random() * 99) + 0);
        setCountStaff((int) (Math.random() * 99) + 3);
    }

    public void calcIndicator(SmallBusiness one, SmallBusiness two, SmallBusiness three, SmallBusiness four, SmallBusiness five){
        int maxStaff = one.getCountStaff();
        String ret = one.getNameShop();

        if (two.getCountStaff() > maxStaff){
            maxStaff = two.getCountStaff();
            ret = two.getNameShop();
        }
        if (three.getCountStaff() > maxStaff){
            maxStaff = three.getCountStaff();
            ret = three.getNameShop();
        }
        if (four.getCountStaff() > maxStaff) {
            maxStaff = four.getCountStaff();
            ret = four.getNameShop();
        }
        if (five.getCountStaff() > maxStaff){
            ret = five.getNameShop();
        }
        System.out.println("Организация с наибольшим числом сотрудников: " + ret);
        StatMethod(ret);
    }

    public static void StatMethod(String name){
        System.out.println("\t\tПроизошел вызов статического метода.");
        System.out.println("\t\tСредний доход компании "+ name +": "+ ((int) (Math.random() * 9999) + 200) + "$");
    }
}
