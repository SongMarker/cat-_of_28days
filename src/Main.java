import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.StreamSupport;


public class Main {
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기
    static int ablity_marble = 1 ;                  //훈련소에 강화할 수 있는 강화재료 변수

    static int winEnemy = 0;            // 적을 무찌른 횟수 변수 (7이후 엔딩으로 이어짐)
    static int cat_coin = 0;            //상점에서 쓸 수 있는 돈


    public static void main(String[] args) throws IOException {

        State cat = new State();        //State 객체인 고양이 설정
        Inventory things = new Inventory(); //아이템 물약 객체 생성
        ArrayList<Integer> fightResult = new ArrayList<Integer>(); //싸움 후 결과 값을 저장하는 list

        firstScene.scene();             //게임 실행 첫 장면

        cat.name = sc.nextLine();       //고양이 이름 정하기

        cat.MaxHP = 5;                  //고양이의 최대 체력
        cat.HP = 5;                     //고양이 체력정하기
        cat.Power =99;                  //고양이 공격력
        cat.Defense = 0;                  //고양이 방어력
        cat.Agility = 10;                //고양이 민첩성
        cat.Critical = 10;               //고양이 치명타

        //인벤토리 포션들 객체

        things.healthPosion = 0;
        things.powerPosion = 0;
        things.defensePosion = 0;
        things.agilityPosion = 0;
        things.criticalPosion = 0;
        things.heallingPosion = 0;



        //장소 리스트 생성

        Lobby.explanatoryText();        //게임 설명문





        while(true){
            if( winEnemy == 6)          //전투를 다 이기게 되면 게임종료
            {
                System.out.println("적을 다 무찔러 마을의 평화를 찾아냈습니다.");
                Ending.ending();
                break;
            }
            State.showCatState(cat.name, cat.MaxHP, cat.HP, cat.Power ,cat.Defense, cat.Agility, cat.Critical);       //고양이 상태표 출력
            Lobby.lobby();                      //로비 선택문 출력

            while(true) {
                int num = sc.nextInt();            //장소 입력하는 입력문

                if (num == 1)                //전투
                {
                    fightResult = Place.showPlace(cat.name, cat.MaxHP, cat.HP, cat.Power, cat.Defense, cat.Agility, cat.Critical, things.healthPosion, things.powerPosion, things.defensePosion, things.agilityPosion, things.criticalPosion, things.heallingPosion);  // park 장소 출력함수

                    if (fightResult.get(1) == 1) {
                        ablity_marble++;
                        cat_coin += 10;
                        winEnemy++;
                    }

                    if (fightResult.get(2) == 1)
                    {
                        things.healthPosion--;
                    }
                    else if (fightResult.get(2) == 2)
                    {
                        things.powerPosion--;
                    }
                    else if (fightResult.get(2) == 3)
                    {
                        things.defensePosion--;
                    }
                    else if (fightResult.get(2) == 4)
                    {
                        things.agilityPosion--;
                    }
                    else if (fightResult.get(2) == 5)
                    {
                        things.criticalPosion--;
                    }
                    else if (fightResult.get(2) == 6)
                    {
                        things.heallingPosion--;
                    }

                    cat.HP = fightResult.get(0);

                    Lobby.anyword();//아무거나 입력하세요

                    break;

                } else if (num == 2)          // 훈련소
                {

                    if (ablity_marble == 0 || ablity_marble < 0)            //강화구슬 재료가 없을떄
                    {
                        System.out.println("강화구슬 재료가 없어서 강화를 못합니다.\n전투에 이겨서 강화구슬 재료를 흭득하세요!");
                        Lobby.anyword();//아무키나 입력하는 입력문
                        System.out.println("======================================================================");
                        break;

                    } else {              //강화 구슬 재료가 있을떄
                        int ablity_num;          //능력치에 접근하기 위해 trainningcenter메소드 return값을 저장하는 변수
                        State.showCatState(cat.name, cat.MaxHP, cat.HP, cat.Power, cat.Defense, cat.Agility, cat.Critical);       //고양이 상태표 출력
                        System.out.println("                       훈련소입니다");
                        ablity_num = TrainingCenter.Trainning();           //훈련소 창 메소드

                        if (ablity_num == 1) {
                            cat.MaxHP += 5;
                            System.out.println("고양이의 최대 체력이 5증가해 " + cat.MaxHP + "이 되었습니다.");


                        } else if (ablity_num == 2) {
                            cat.Power++;
                            System.out.println("고양이의 힘이 1증가해 " + cat.Power + "이 되었습니다.");


                        } else if (ablity_num == 3) {
                            cat.Defense++;
                            System.out.println("고양이의 방어력이 1증가해 " + cat.Defense + "이 되었습니다.");


                        } else if (ablity_num == 4) {
                            cat.Agility += 5;
                            System.out.println("고양이의 민첩성이 5% 증가해 " + cat.Agility + "%가 되었습니다.");


                        } else if (ablity_num == 5) {
                            cat.Critical += 5;
                            System.out.println("고양이의 치명타확률이 5% 증가해 " + cat.Critical + "%가 되었습니다.");

                        }

                        ablity_marble--;            //강화구슬 소진
                        Lobby.anyword();//아무키나 입력하는 입력문
                        break;
                    }
                } else if (num == 3)          //쉼터
                {
                    CatFasion.restCat();
                    System.out.println("                       쉼터입니다");

                    cat.HP = cat.MaxHP;
                    System.out.println("고양이의 체력이 회복되었습니다.");
                    System.out.println("체력 : " + cat.HP + " -> " + cat.MaxHP);

                    Lobby.anyword();  //아무키나 입력하는 입력문
                    break;

                } else if (num == 4) {
                    System.out.println("상점입니다");
                    int storeNum = Store.store(cat_coin);

                    if (storeNum == 1) {
                        System.out.println("체력강화물약을 하나 구입하였습니다!");
                        things.healthPosion++;
                        cat_coin -= 5;

                    } else if (storeNum == 2) {
                        System.out.println("힘강화물약을 하나 구입하였습니다!");
                        things.powerPosion++;
                        cat_coin -= 5;

                    } else if (storeNum == 3) {
                        System.out.println("방어력강화물약을 하나 구입하였습니다!");
                        things.defensePosion++;
                        cat_coin -= 5;

                    } else if (storeNum == 4) {
                        System.out.println("민첩강화물약을 하나 구입하였습니다!");
                        things.agilityPosion++;
                        cat_coin -= 5;

                    } else if (storeNum == 5) {
                        System.out.println("치명타강화물약을 하나 구입하였습니다!");
                        things.criticalPosion++;
                        cat_coin -= 5;

                    } else if (storeNum == 6) {
                        System.out.println("체력회복물약을 하나 구입하였습니다!");
                        things.heallingPosion++;
                        cat_coin -= 5;

                    } else //0반환될떄
                        System.out.println("");

                    Lobby.anyword();//아무키나 입력하는 입력문
                    break;

                } else if (num == 5) {
                    Inventory.inventory(ablity_marble, cat_coin, things.heallingPosion, things.powerPosion, things.defensePosion, things.agilityPosion, things.criticalPosion, things.heallingPosion);

                    Lobby.anyword();//아무키나 입력하는 입력문
                    break;
                } else
                    System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요!");
            }

        }



    }
}