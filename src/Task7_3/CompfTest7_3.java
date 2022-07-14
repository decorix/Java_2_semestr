package Task7_3;

import java.util.Scanner;

public class CompfTest7_3 {
    public static void main(String[] args) throws Exception {
        Compf7_3 c = new Compf7_3();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("¬ведите формулу -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}
