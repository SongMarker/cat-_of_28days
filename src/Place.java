import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Place {
    static ArrayList<String> place = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기

    static int count = 0; // 엔딩을 보게 하는 변수

    static ArrayList showPlace(String Cat_name, int Cat_MaxHP ,int Cat_HP, int Cat_Power, int Cat_Defense, int Cat_Agility, int Cat_Critical, int HealthPosion, int PowerPosion, int DefensePosion, int AgilityPosion, int CriticalPosion, int HeallingPosion) throws IOException {
        ArrayList<Integer> fightResult = new ArrayList<Integer>(); //싸움 후 결과 값을 저장하는 list

        if (count == 0) {                        //리스트 목록 추가
            place.add("1 공원");
            place.add("2 학교");
            place.add("3 시장");
            place.add("4 시청");
            place.add("5 군대");
            place.add("6 연구소");
        }
        if (count == 0)
            count++;

        for (int i = 0; i < place.size(); i++) {
            System.out.println(place.get(i));
        }
        System.out.print("\n");
        System.out.println("숫자를 입력해주세요!");

        while (true) {
            int num = sc.nextInt();

            if (num == 1)
            {
                //공원일떄
                fightResult = Park.Park_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;

            } else if (num == 2) {
                //학교일때
                fightResult = School.school_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;

            } else if (num == 3) {
                fightResult = Market.market_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;

            } else if (num == 4) {
                fightResult = Town_Hall.town_hall_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;
            } else if (num == 5) {
                fightResult = Army.army_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;
            } else if (num == 6) {
                fightResult = Laboratory.laboratory_fight(Cat_name, Cat_MaxHP ,Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical, HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);
                return fightResult;
            } else
                System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요!");
        }

    }

}


