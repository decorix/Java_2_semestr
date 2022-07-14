package Task2_5;

import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String word) throws Exception {
        Deq deq = new Deq(word.length());

        for (int i = 0; i < word.length(); i++) {
            deq.pushFront(word.charAt(i));
        }

        for (int i = 0; i < deq.getSize() / 2; i++) {
            if (deq.popFront() != deq.popBack()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        isPalindrome(str);
    }
}
