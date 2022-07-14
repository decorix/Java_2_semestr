package Task8_3;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        Scanner in = new Scanner(System.in);
        String str = "";
        while (in.hasNextLine()) {
            str += in.nextLine();
            System.out.print("Текущая строка: " + str);
        }
    }
}
