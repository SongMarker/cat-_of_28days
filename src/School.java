import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기

    static int Enemy_HP = 2;               //적 능력치
    static int Enemy_Power = 1;
    static int Enemy_Defense = 0;
    static int Enemy_Agility = 70;


    static int Concentration = 0;           //집중하기 횟수 변수
    static int ItemUse = 0;                 //아이템 사용횟수

    static int fightEndNum = 0;            //전투 끝 변수



    static ArrayList school_fight(String Cat_name, int Cat_MaxHP ,int Cat_HP, int Cat_Power, int Cat_Defense, int Cat_Agility, int Cat_Critical, int HealthPosion, int PowerPosion, int DefensePosion ,int AgilityPosion, int CriticalPosion, int HeallingPosion) throws IOException {
        ArrayList<Integer> fightResult = new ArrayList<Integer>(); //싸움 후 결과 값을 저장하는 list
        System.out.println("\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣛⠿⣿⣷⡦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠟⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠿⣧⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⡁⠂⠌⠻⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⡁⠂⠄⠡⠈⠄⡉⠻⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⡁⠂⠄⣡⣼⣦⣥⣆⠠⢁⠘⠻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⡁⠂⠄⢡⣾⠛⠁⠀⠈⠹⣷⡀⠌⡐⠈⠿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣟⣁⣂⠄⠡⢈⠰⣿⠀⠀⠀⠀⠀⣽⠆⡐⠠⢁⣢⣘⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⣿⠀⡁⠂⠄⠹⢷⣤⣠⣤⣾⠏⡐⠠⢁⠂⣿⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣿⠀⠄⠡⢈⠐⠠⢁⠡⠈⠄⡐⠠⢁⠂⠄⣿⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡏⠉⢉⠉⢉⠉⢉⠉⢉⠉⢉⠉⢉⠉⣿⠀⠌⣐⣠⣈⣐⣀⣂⣁⣂⣄⣁⣂⠌⡀⣿⡉⠉⡉⠉⡉⠉⡉⠉⡉⠉⡉⠉⡉⢹⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠈⠄⡈⣴⣬⣦⣼⣤⣮⡄⠈⠄⠂⣿⠀⠂⣿⡟⠙⠋⠛⠙⠋⠛⠙⠛⣿⠀⠄⣿⠄⠡⢀⠡⣴⣥⣦⣵⣤⣥⠠⢁⠐⣸⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⢁⠂⠄⣿⡇⠀⠀⠀⣿⡇⠈⠄⠡⣿⠀⡁⠻⢷⠶⡷⢶⠷⡶⢷⠶⠿⡟⢀⠂⣿⠌⡐⠠⠘⣿⠀⠀⠀⢸⣿⠀⢂⠐⣸⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠠⠈⠄⣿⣇⣀⣀⣀⣿⡇⠈⠄⡁⣿⠀⠄⣡⣦⣴⣤⣦⣴⣤⣦⣬⣴⣄⠂⠄⣿⠂⠄⠡⠘⣿⣀⣀⣀⣸⣿⠀⢂⠐⢸⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠄⠃⠄⡙⠛⠛⠛⠛⠛⡁⠌⡐⠀⣿⠀⠌⣿⡏⠉⠉⠉⠉⠉⠉⠉⠉⣿⠀⠂⣿⠡⠈⠄⡉⠛⠛⠛⠛⠛⢋⠐⡈⠄⢹⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⢈⠐⠄⣠⣁⢌⡐⣁⣂⠐⠠⢀⠡⣿⠀⠂⣿⡇⠀⠀⠀⠀⠀⠀⠀⢈⣿⠀⡁⣿⠡⢈⠐⠠⣁⡌⣂⣡⢈⡄⢂⠐⡈⢼⡃⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠠⠈⠄⣿⡏⠉⠉⠉⣿⡇⠠⢁⠂⣿⠀⡁⣿⡇⠀⠀⠀⠀⠀⠀⠀⠠⣿⠀⠄⣿⡁⠂⠌⠰⣿⠉⠉⠉⢹⣿⠀⢂⠐⣸⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠄⠃⠄⣿⡇⠀⠀⠀⣿⡇⠐⡀⢂⣿⠀⠄⣿⡇⠀⠀⠀⠀⠀⠀⠀⠐⣿⠀⠂⣿⠄⠡⢈⠰⣿⠀⠀⠀⢸⣿⠀⢂⡐⢸⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⢈⠐⠠⠻⢷⠾⠾⠷⠿⢃⠐⡀⠂⣿⠀⠂⣿⡇⠀⠀⠀⠀⠀⠀⠀⢈⣿⠀⡁⣿⠌⡐⢀⠒⠿⢾⠶⠿⢾⠟⡀⢂⠐⣸⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡇⠠⠈⠄⡁⠂⠌⠠⠁⠌⡀⠂⠄⠡⣿⠀⡁⣿⡇⠀⠀⠀⠀⠀⠀⠀⠠⣿⠀⠄⣿⢂⠐⠠⢈⠐⠠⢈⠐⡀⢂⠐⡀⠂⢼⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠨⠷⠿⠾⠷⠟⠿⠾⠷⠿⠾⠷⠿⠾⠷⠿⠾⠷⠿⠷⠾⠷⠿⠾⠷⠿⠾⠷⠿⠿⠞⠿⠾⠾⠷⠿⠾⠷⠿⠾⠷⠿⠾⠷⠿⠾⠃⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");

        System.out.println("학교입니다");
        Lobby.anyword();

        while(true) {

            if(Cat_HP == 0 || Cat_HP < 0)     //고양이의 체력이 0이하가 되었을 때
            {
                System.out.println("고양이의 체력이 다 달아서 기절 하였습니다.");
                System.out.println("전투를 패배하셨습니다.");

                Enemy_HP = 2;       //*
                Cat_HP = 0;

                fightResult.add(0,Cat_HP);          // 고양이의 체력과 졌다는 변수 1 저장값 list
                fightResult.add(1,0);
                fightResult.add(2,0);


                return fightResult;
            }
            else if (fightEndNum == 1)
            {
                System.out.println("전에 적을 무찔러 고요함만 남아있습니다.");

                fightResult.add(0,Cat_HP);          // 고양이의 체력과 이겼다는 변수상태 저장값 list
                fightResult.add(1,0);
                fightResult.add(2,0);


                return fightResult;
            }
            else if (Enemy_HP < 1)
            {
                System.out.println("적을 무찔렀습니다.");
                System.out.println("전투에서 승리하셨습니다.");
                System.out.println("강화 구슬과 돈 10원을 흭득하셨습니다.");

                fightResult.add(0,Cat_HP);          // 고양이의 체력과 이겼다는 변수 1 저장값 list
                fightResult.add(1,1);
                fightResult.add(2,ItemUse);

                fightEndNum++;                            // 또 보상받을 수 없도록 하는 변수

                return fightResult;
            }









            Enemy.school_zombie(Enemy_HP, Enemy_Power, Enemy_Defense, Enemy_Agility);    //적 모습 출력
            CatFasion.basic_back(Cat_name, Cat_HP, Cat_Power, Cat_Defense, Cat_Agility, Cat_Critical); //고양이 모습출력

            Lobby.fightOrRun();         //싸운다, 도망간다 선택문
            int num = sc.nextInt();     //숫자 입력

            while(true) {
                if (num == 1) { //싸웠을 때

                    Lobby.fight();

                    int num1 = sc.nextInt();     //숫자 입력

                    while(true)
                    {
                        if(num1 == 1)   //공격
                        {
                            System.out.println("고양이의 공격");

                            Enemy_HP = FightCalculator.CatAttack(Cat_name, Enemy_HP, Enemy_Agility, Enemy_Defense, Cat_Power, Cat_Critical);   //고양이 공격
                            Cat_HP = FightCalculator.EnemyAttack(Cat_name, Cat_HP, Cat_Agility, Cat_Defense ,Enemy_Power);   //적의 공격

                            Lobby.anyword();
                            break;
                        }
                        else if (num1 == 2) // 집중하기
                        {

                            if(Cat_HP != Cat_MaxHP)
                                Cat_HP++;

                            Concentration++;

                            System.out.println("고양이가 손을 모으며 집중자세를 취합니다");

                            if (Concentration == 8)
                            {

                                CatFasion.awake();

                                Cat_Power = 99;
                                Cat_Defense = 99;
                                Cat_Agility = 99;
                                Cat_Critical = 99;

                                Lobby.anyword();
                                break;
                            }

                            System.out.println(String.format("(집중한 횟수 %d)", Concentration));
                            System.out.println("(집중하게 되면은 방어력과 체력이 회복과 강화됩니다.)");
                            System.out.println("(최대 8번까지 효과가 있고 8번째에 각성을 하게 됩니다.)");


                            System.out.println("");
                            Cat_HP = FightCalculator.EnemyAttack(Cat_name, Cat_HP, Cat_Agility, Cat_Defense ,Enemy_Power);   //적의 공격

                            Lobby.anyword();
                            break;
                        }
                        else if (num1 == 3) //쉬기
                        {
                            System.out.println("쉬면서 전투의 피곤함을 달랬다.");
                            System.out.println("쉬게 되면 피를 회복할 수 있지만 방어력과 회피력이 떨어지게 된다.");

                            Cat_HP = Cat_MaxHP ;
                            Cat_Defense /= 2;
                            Cat_Agility /= 2;
                            System.out.println(String.format("체력  %d -> %d",Cat_HP, Cat_MaxHP));
                            System.out.println(String.format("방어력 -> %d, 회피력 -> %d",Cat_Defense, Cat_Agility));

                            Lobby.anyword();
                            break;
                        }
                        else if (num1 == 4) //인벤토리
                        {

                            if (ItemUse > 0)
                            {
                                System.out.println("아이템을 한번 사용해서 다시 사용하지 못합니다.");

                                Lobby.anyword();
                                break;
                            }

                            Lobby.fightInven(HealthPosion, PowerPosion, DefensePosion, AgilityPosion, CriticalPosion, HeallingPosion);

                            int PosionNum = sc.nextInt();       //포션 선택값 저장변수



                            if(HealthPosion > 0 && PosionNum == 1)
                            {
                                System.out.println("체력강화 물약을 사용해서 체력을 2배 늘렸습니다.");
                                System.out.println(String.format("%d -> %d",Cat_MaxHP, 2*Cat_MaxHP));

                                Cat_MaxHP = Cat_MaxHP*2;
                                ItemUse = 1;

                                Lobby.anyword();
                                continue;
                            }
                            else if (PowerPosion > 0 && PosionNum == 2)
                            {
                                System.out.println("힘강화 물약을 사용해서 공격력을 2배 늘렸습니다.");
                                System.out.println(String.format("%d -> %d",Cat_Power, 2*Cat_Power));

                                Cat_Power = Cat_Power*2;

                                ItemUse = 2;
                                Lobby.anyword();
                                continue;
                            }
                            else if (DefensePosion > 0 && PosionNum == 3)
                            {
                                System.out.println("방어력강화 물약을 사용해서 방여력을 2배 늘렸습니다.");
                                System.out.println(String.format("%d -> %d",Cat_Defense, 2*Cat_Defense));


                                Cat_Defense = Cat_Defense*2;

                                ItemUse = 3;
                                Lobby.anyword();
                                continue;
                            }
                            else if (AgilityPosion > 0 && PosionNum == 4)
                            {
                                System.out.println("치명타강화 물약을 사용해서 치명타를 2배 늘렸습니다.");
                                System.out.println(String.format("%d -> %d",Cat_Critical, 2*Cat_Critical));

                                Cat_Critical = Cat_Critical*2;

                                ItemUse = 4;
                                Lobby.anyword();
                                continue;
                            }
                            else if (CriticalPosion > 0 && PosionNum == 5)
                            {
                                System.out.println("체력회복 물약을 사용해서 체력회복을 했습니다.");
                                System.out.println(String.format("%d -> %d", Cat_HP, Cat_MaxHP));

                                Cat_HP = Cat_MaxHP;

                                ItemUse = 5;
                                Lobby.anyword();
                                continue;
                            }
                            else if (HeallingPosion > 0 && PosionNum == 6)
                            {
                                System.out.println("힘강화 물약을 사용해서 공격력을 2배 늘렸습니다.");
                                System.out.println(String.format("%d -> %d",Cat_Power, 2*Cat_Power));

                                Cat_Power = Cat_Power*2;

                                ItemUse = 6;
                                Lobby.anyword();
                                continue;
                            }
                            else
                            {
                                System.out.println("포션이 없거나 잘못 눌러서 뒤로 돌아갔습니다.");
                                Lobby.anyword();
                                break;
                            }



                        }
                        else
                            System.out.println("잘못입력하셨습니다. \n다시 입력해주세요!");
                    }
                    break;

                } else if (num == 2) {  //도망갔을 때
                    System.out.println("좀비한테서 도망쳤습니다.");
                    System.out.println("도망칠때 긁히고 넘어지면서 체력이 줄어듭니다.");

                    Concentration = 0;

                    fightResult.add(0,Cat_HP/2);          // 고양이의 체력과 이겼다는 변수 1 저장값 list
                    fightResult.add(1,0);
                    fightResult.add(2,0);

                    return fightResult;

                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. \n다시 입력해주세요!");
                }
            }
        }
    }
}
