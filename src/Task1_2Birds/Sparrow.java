package Task1_2Birds;

import java.awt.*;

public class Sparrow extends Bird {
    private static int count = 0;

    public Sparrow(){
        size = 6;
        color = new Color(90, 90, 90);
    }

    public static void printCount(){ // метод класса
        System.out.println("Всего воробьев: " + count);
    }
}
