import javax.swing.text.DefaultEditorKit;
import java.io.IOException;
import java.util.Scanner;

public class FightCalculator {

    static Scanner sc = new Scanner(System.in);   //Scanner 객체 이용으로 숫자입력받는 함수 가져오기

    static int EnemyAttack(String Cat_Name ,int Cat_HP, int Cat_agility, int Cat_Defense ,int Enemy_power) throws IOException     // 적의 공격
    {
        int num = (int)(Math.random() * 100);
        int damage = 0; // 고양이가 받아야할 데미지

        if (num <= Cat_agility)         //회피
        {
            System.out.println("적의 공격을 회피해 체력이 닳지 않았습니다.");
            return Cat_HP;
        }
        else {
            damage = Enemy_power - Cat_Defense;         //위 계산식의 뺄샘이 나오면 0으로 맞춰주는 식

            if (damage < 1)
                damage = 0;

            int result = (Cat_HP - damage);

            if(damage == 0)
                System.out.println((String.format("적의 공격을 방어했습니다. 체력: %d -> %d", Cat_HP, result)));
            else
                System.out.println((String.format("적이 공격해 %s 체력이 %d -> %d로 되었습니다.",Cat_Name ,Cat_HP, result)));

            return result;
        }
    }










    static int CatAttack(String Cat_Name,int Enemy_HP, int Enemy_agility, int Enemy_Defense, int Cat_power, int Cat_Critical ) throws IOException // 고양이의 공격
    {
        int num = (int)(Math.random() * 100);

        if (num <= Enemy_agility)
        {
            System.out.println("적이 공격을 회피해 체력이 닳지 않았습니다.");
            return Enemy_HP;
        }
        else {
            int result = 0;                     //적의 체력을 저장하는 변수
            int damage = 0;                     //적이 받아야할 데미지
            if (num <= Cat_Critical)
            {
                damage = Cat_power;
                result = (Enemy_HP - (damage*2));
                System.out.println((String.format("적을 공격해 적의 체력이 %d -> %d로 되었습니다.", Enemy_HP, result)));
            }
            else {
                damage = Cat_power - Enemy_Defense;

                if ( damage < 1)
                    damage = 0;         //위 계산식의 뺄샘이 나오면 0으로 맞춰주는 식

                result = (Enemy_HP - damage);

                if(damage == 0)
                    System.out.println((String.format("적이 %s의 공격을 방어했습니다. 체력 : %d -> %d",Cat_Name ,Enemy_HP, result)));
                else
                    System.out.println((String.format("적을 공격해 적의 체력이 %d -> %d로 되었습니다.", Enemy_HP, result)));
            }
            return result;

        }
    }









}
