package miningUniversity.Practice8;


enum SmallBusiness{
    BeautyParlour(0, "BARBERSHOP"),
    BabyBarberShop(0, "BARBERSHOP"),
    CurlyHairSalon(0,"BARBERSHOP"),
    ClothesShop(0, "SHOP"),
    PetStore(0, "SHOP"),
    HardwareStore(0, "SHOP");

    private int countStaff;
    private String type;

    SmallBusiness(int countStaff, String type) {this.countStaff = countStaff; this.type = type;}
    int getCountStaff(){ return countStaff;}
    void setCountStaff(int countStaff){ this.countStaff = countStaff;}
    String getType(){return type;}
    }

class JavaEnum {
    public static void main(String[] args) {
        for(SmallBusiness biz : SmallBusiness.values()){
            biz.setCountStaff((int) (Math.random() * 99) + 3);
            System.out.println(biz.ordinal() + ". " + biz.name() + "   COUNT STAFF: " + biz.getCountStaff() + "    TYPE: " +  biz.getType());
        }
        maxStaffSmallBusiness();
    }
    static void maxStaffSmallBusiness(){
        SmallBusiness biz = SmallBusiness.BeautyParlour;
        if (biz.getCountStaff() < SmallBusiness.BabyBarberShop.getCountStaff()) biz = SmallBusiness.BabyBarberShop;
        if (biz.getCountStaff() < SmallBusiness.CurlyHairSalon.getCountStaff()) biz = SmallBusiness.CurlyHairSalon;
        if (biz.getCountStaff() < SmallBusiness.ClothesShop.getCountStaff()) biz = SmallBusiness.ClothesShop;
        if (biz.getCountStaff() < SmallBusiness.PetStore.getCountStaff()) biz = SmallBusiness.PetStore;
        if (biz.getCountStaff() < SmallBusiness.HardwareStore.getCountStaff()) biz = SmallBusiness.HardwareStore;
        System.out.println("\n" + biz.ordinal() + ". NAME: " + biz.name() + "  COUNT STAFF: " + biz.getCountStaff() + "    TYPE: " +  biz.getType() + "\n");
    }
}
