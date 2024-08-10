
public class State {
    String name;
    int MaxHP;
    int HP;
    int Power;
    int Defense;
    int Agility;
    int Critical;

    static void showCatState(String CatName, int CatMaxHP, int CatHP, int CatPower, int CatDefense, int CatAgility, int CatCritical){

        System.out.println("======================================================================");


        CatFasion.basic();
        System.out.println("======================================================================");
        System.out.println("이름 : " + CatName + "\n" +
                        "최대 체력 : " + CatMaxHP + "\n" +
                        "현재 체력 : " + CatHP + "\n" +
                        "공격력 : " + CatPower + "\n" +
                        "방어력 : " + CatDefense + "\n" +
                        "민첩성(회피력) : " + CatAgility +"%\n" +
                        "치명타 : " + CatCritical + "%\n"+
                       "(강화구슬과 물약은 인벤토리에서 확인가능합니다!)" );

        System.out.println("======================================================================");


    }

}
