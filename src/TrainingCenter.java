import java.util.Scanner;


public class TrainingCenter {
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기
    static int num;                             //반환하는 값을 갖는 변수


    static int Trainning(){            //능력치 올리는 메소드

            System.out.println(" __| |____________________________________________| |__\n" +
                    "(__   ____________________________________________   __)\n" +
                    "   | |                                            | |\n" +
                    "   | |        1.체력               2.공격력         | |\n" +
                    "   | |                                            | |\n" +
                    "   | |                                            | |\n" +
                    "   | |        3.스테미나            4.민첩성         | |\n" +
                    "   | |                                            | |\n" +
                    "   | |                                            | |\n" +
                    "   | |                  5.치명타                   | |\n" +
                    " __| |dc__________________________________________| |__\n" +
                    "(__   ____________________________________________   __)\n" +
                    "   | |                                            | |\n" +
                    "               무슨 능력치를 올리실 것인가요??            ");


            while (true)                                         //숫자를 잘 입력했는지 확인문
            {
                num = sc.nextInt();
                if (num < 6 && num != 0) {
                    break;
                } else
                    System.out.println("잘못된 숫자를 입력하셨습니다. \n숫자를 다시 입력하시오!");
            }

            return num;

    }
}
