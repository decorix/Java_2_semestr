package Task8_3;

import java.util.Scanner;

//���� ��� ������������ ������.
public class CalcTest{
    public static void main(String[] args){
        Calc c = new Calc();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("������� ������� -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}
