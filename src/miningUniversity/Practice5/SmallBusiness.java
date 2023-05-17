package miningUniversity.Practice5;

abstract class SmallBusiness {
    private String nameShop;
    private int countStaff;

    public SmallBusiness(String nameShop, int countStaff) {
        this.nameShop = nameShop;
        this.countStaff = countStaff;
    }

    public int getCountStaff(){  // метод для получения информации о количестве сотруднико
        return countStaff;
    }

    public String getNameShop(){   // метод для получения информации о наименовании организации
        return nameShop;
    }

    public String calcIndicator(SmallBusiness one, SmallBusiness two){
        if (one.getCountStaff() > two.getCountStaff()){
            return one.getNameShop();
        } else return two.getNameShop();
    }
}
