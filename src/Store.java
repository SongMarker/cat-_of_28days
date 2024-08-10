import java.util.Scanner;

public class Store extends State{
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기
    static int num;             //반환하는 값을 담는 변수

    static int store(int catcoin)
    {

        System.out.println(String.format(" __| |____________________________________________| |__\n" +
                "(__   ____________________________________________   __)\n" +
                "   | |        물약 하나당 고양이 동전 5원씩 든다        | |\n" +
                "   | |                                            | |\n" +
                "   | |     1.체력강화물약           2.힘강화물약       | |\n" +
                "   | |                                            | |\n" +
                "   | |     3.방어력강화물약          4.민첩강화물약    | |\n" +
                "   | |                                            | |\n" +
                "   | |     5.치명타강화물약          6.체력회복물약    | |\n" +
                "   | |                                            | |\n" +
                "   | |              (현재 코인 : %d$ )              | |\n" +
                "   | |       (강화물약은 능력치를 두배 증가 시킨다)     | |\n" +
                "   | |        (강화물약은 전투시 한번만 사용가능)       | |\n" +
                "   | |                                            | |\n" +
                " __| |dc__________________________________________| |__\n" +
                "(__   ____________________________________________   __)\n" +
                "   | |                                            | |", catcoin));

        while(true) {
            num = sc.nextInt();         //입력받기

            if (catcoin == 0 || catcoin < 0)
            {
                System.out.println("캣 코인이 없습니다. 전투에서 이기면 캣코인을 흭득하는데 그것으로 구매가능합니다.");
                num = 0;
                break;
            }
            else if(num <= 0 && num > 4)
                System.out.println("잘못된 숫자를 입력하셨습니다. \n다시 입력해주세요!");
            else
                break;
        }

        System.out.println("======================================================================");

        return num;

    }
}
