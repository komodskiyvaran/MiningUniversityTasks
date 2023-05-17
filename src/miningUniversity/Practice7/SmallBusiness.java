package miningUniversity.Practice7;


class SmallBusiness implements CalcuIndicator{
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

    public int getCountStaff(){ // метод для получения информации о количестве сотруднико
        return countStaff;
    }

    public String getNameShop(){ // метод для получения информации о наименовании организации
        return nameShop;
    }

    public int getID(){     // метод для получения ID
        return ID;
    }

    public void refactor() {        // Изменение параметров объекта
        setCountStaff((int) (Math.random() * 99) + 3);
    }


    public void calcIndicator(SmallBusiness one, SmallBusiness two, SmallBusiness three, SmallBusiness four) {
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
                ret = four.getNameShop();
            }
            System.out.println("Организация с наибольшим числом сотрудников: " + ret);
    }
}
