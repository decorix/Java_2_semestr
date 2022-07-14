package Task1_1Birds;

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
        g.fillOval(p.getX() - size/4, -p.getY() - size/4, size/4, size/4);
    }
}
