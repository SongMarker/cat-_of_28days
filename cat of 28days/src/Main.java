import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.StreamSupport;


public class Main {
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기
    static int ablity_marble = 1 ;                  //훈련소에 강화할 수 있는 강화재료 변수
    static int ablity_num ;                      //능력치에 접근하기 위해 trainningcenter메소드 return값을 저장하는 변수

    static int cat_coin = 0;            //상점에서 쓸 수 있는 돈


    public static void main(String[] args) {

        State cat = new State();        //State 객체인 고양이 설정
        Inventory things = new Inventory();

        firstScene.scene();             //게임 실행 첫 장면

        cat.name = sc.nextLine();       //고양이 이름 정하기

        cat.MaxHP = 5;
        cat.HP = 5;                     //고양이 체력정하기
        cat.power = 1;                  //고양이 공격력
        cat.charm = 1;                  //고양이 마력
        cat.agility = 1;                //고양이 민첩성
        //Critical Hit  치명타

        //인벤토리 포션들 객체

        things.healthyPosion = 0;
        things.powerPosion= 0;
        things.charmPosion= 0;
        things.agilityPosion= 0;



        //장소 리스트 생성

        Lobby.explanatoryText();        //게임 설명문

        State.showCatState(cat.name, cat.MaxHP, cat.HP, cat.power ,cat.charm, cat.agility );       //고양이 상태표 출력




        while(true){
            Lobby.lobby();      //로비 선택문 출력
            int num = sc.nextInt();            //장소 입력하는 입력문

            if(num == 1)
            {
                Place.showPlace();



            }
            else if (num == 2)
            {

                if (ablity_marble == 0 || ablity_marble < 0)            //강화구슬 재료가 없을떄
                {
                    System.out.println("강화구슬 재료가 없어서 강화를 못합니다.\n전투에 이겨서 강화구슬 재료를 흭득하세요!");
                    System.out.println("======================================================================");

                }

                else {              //강화 구슬 재료가 있을떄
                    State.showCatState(cat.name, cat.MaxHP, cat.HP, cat.power, cat.charm, cat.agility);       //고양이 상태표 출력
                    System.out.println("                       훈련소입니다");
                    ablity_num = TrainingCenter.Trainning();           //훈련소 창 메소드

                    if (ablity_num == 1) {
                        cat.MaxHP++;
                        System.out.println("고양이의 최대 체력이 1증가해 " + cat.MaxHP + "이 되었습니다.");

                    } else if (ablity_num == 2) {
                        cat.power++;
                        System.out.println("고양이의 힘이 1증가해 " + cat.power + "이 되었습니다.");


                    } else if (ablity_num == 3) {
                        cat.charm++;
                        System.out.println("고양이의 마력이 1증가해 " + cat.charm + "이 되었습니다.");

                    } else if (ablity_num == 4) {
                        cat.agility++;
                        System.out.println("고양이의 민첩성이 1증가해 " + cat.agility + "이 되었습니다.");
                    }
                    ablity_marble--;
                }
            }
            else if (num == 3)
            {
                System.out.println("                       쉼터입니다");

                cat.HP = cat.MaxHP;
                System.out.println("고양이의 체력이 회복되었습니다.");
                System.out.println("체력 : " + cat.HP+" -> "+cat.MaxHP);

            }
            else if (num == 4)
            {
                System.out.println("상점입니다");
                Store.store(cat_coin);
            }
            else if (num == 5)
            {

            }
            else
                System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요!");
        }



    }
}