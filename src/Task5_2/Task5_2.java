package Task5_2;

import java.util.Scanner;

public class Task5_2 {
    public static void main(String[] args) {
        String regex1 = "";
        String regex2 = "a";
        String regex3 = "ab";
        String regex4 = "a|b";
        String regex5 = "a*";
        String regex6 = "a+";
        String regex7 = "aa*"; //Эквивалент regex6.
        String regex8 = "\\**";
        String regex9 = "a*b*";
        String regex10 = "aa*bb*";
        String regex11 = "a*|b*";
        String regex12 = "(a|b)*";
        String regex13 = "a|b*";
        String regex14 = "(aab|ab)*";

        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine();
            //boolean result = input.matches(regex1); //Проверка строки на соответсвие регулярному выражению (языку).
            boolean result = exercise2(input);
            System.out.println(result);
        }
    }

    public static boolean exercise1(String str) { // Задание №1
        return str.matches("[1-9][0-9]*");
    }

    public static boolean exercise2(String str) {
        return str.matches("([1-9][0-9]+\\W[0-9]*)|([0-9]\\W[1-9]+)|([1-9]+[0-9]*)|([0-9]\\W[0-9]+[1-9])|(\\W[1-9]+\\W[0-9]+)");
    }

    public static boolean exercise3(String str) {
        return str.matches("\\w{3,}@\\w+\\.[a-zA-Z]+");
    }

}
