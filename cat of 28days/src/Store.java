import java.util.Scanner;

public class Store extends State{
    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기
    static int num;             //반환하는 값을 담는 변수

    static int store(int catcoin)
    {

        System.out.println(" __| |____________________________________________| |__\n" +
                "(__   ____________________________________________   __)\n" +
                "   | |        물약 하나당 고양이 동전 1나씩 든다        | |\n" +
                "   | |                   1.체력물약                 | |\n" +
                "   | |                   2.힘물약                   | |\n" +
                "   | |                   3.마력물약                 | |\n" +
                "   | |                   4.민첩물약                 | |\n" +
                "   | |  (물약은 능력치를 두배증가 시킨다. 전투떄 한번 사용)| |\n" +
                " __| |dc__________________________________________| |__\n" +
                "(__   ____________________________________________   __)\n" +
                "   | |                                            | |");

        while(true) {
            num = sc.nextInt();         //입력받기

            if (catcoin == 0 || catcoin < 0)
            {
                System.out.println("잘못된 숫자를 입력하셨습니다.\n다시 입력해주세요!");
            }
            else
                break;
        }

        return num;

    }
}
