public class Inventory {
    int healthPosion;
    int powerPosion;
    int defensePosion;
    int agilityPosion;
    int criticalPosion;
    int heallingPosion;




    static void inventory(int ablityMarble, int catCoin, int healthyPosion, int powerPoison, int defensePosion, int agilityPosion, int criticalPosion, int heallingPosion) {
        System.out.println("                          인벤토리입니다");

        System.out.println("======================================================================");
        System.out.println("강화구슬 : "+ ablityMarble);
        System.out.println("캣코인 : "+ catCoin+"$");
        System.out.println("체력강화포션 : " + healthyPosion);
        System.out.println("힘강화포션 : " + powerPoison);
        System.out.println("방어력강화포션 : " + defensePosion);
        System.out.println("민첩강화포션 : " + agilityPosion);
        System.out.println("치명타강화포션 : " + criticalPosion);
        System.out.println("체력회복포션 : " + agilityPosion);
        System.out.println("======================================================================");

    }
}
