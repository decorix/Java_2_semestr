package Task1_2Birds;

import java.awt.*;

public class Penguin extends Bird {
    private static int count = 0;

    public Penguin(){
        count++;
        System.out.println("Я пингвин.");

        size = 20;
        color = new Color(0, 0, 0);
    }

    @Override
    public void fly(){ // переопределение метода
        System.out.println("Я не умею летать!");
    }

    public void hello(Penguin p){
        System.out.println("Привет пингвин! Я пингвин.");
    }

    public void hello(Parrot p){ // перегрузка метода
        System.out.println("Привет, попугай " + p.getName() + "! Я пингвин.");
    }

    public static void printCount(){ // метод класса
        System.out.println("Всего пингвинов: " + count);
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(Color.WHITE);
        g.fillOval(x - size/4, -y - size/4, size/4, size/4);
    }
}
