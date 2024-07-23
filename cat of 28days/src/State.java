
public class State {
    String name;
    int MaxHP;
    int HP;
    int power;
    int charm;
    int agility;

    static void showCatState(String CatName, int CatMaxHP, int CatHP, int CatPower, int CatCharm, int CatAgility){

        System.out.println("======================================================================");


        CatFasion.basic();
        System.out.println("======================================================================");
        System.out.println("이름 : " + CatName + "\n" +
                        "최대 체력 : " + CatMaxHP + "\n" +
                       "현재 체력 : " + CatHP + "\n" +
                       "공격력 : " + CatPower + "\n" +
                       "마력 : " + CatCharm + "\n" +
                        "민첩성 : " + CatAgility );

        System.out.println("======================================================================");


    }

}
