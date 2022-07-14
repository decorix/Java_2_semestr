package Task1_1Birds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){ // точка входа в программу
        /*
        //Bird b1 = new Bird(); // создание объекта (экземпяра) класса
        //Bird b2 = b1;
        //b1.fly(); // пример вызова метода экземпяра класса; инкапсуляция

        Parrot p1 = new Parrot();
        //Parrot p2 = p1;
        //p1.fly();
        //p1.speak();
        Parrot p2 = new Parrot();
        //p2.speak();
        //p2.name = "Гоша";
        //p2.rename("Гоша");
        //p2.setName("Гоша");
        //p2.speak();
        //p1.speak();
        //System.out.println(p2.getName());
        Parrot p3 = new Parrot("Клёпа");
        //p3.speak();

        Penguin p4 = new Penguin();
        p4.fly();

        Penguin p5 = new Penguin();
        Bird.printCount();
        p5.fly();

        p4.hello(p5);
        p4.hello(p4); // полиморфизм
        p4.hello(p3);
        p3.hello(p4); // полиморфизм
        p3.hello(p3);

        //Bird b = new Bird();
        Bird b = new Parrot();
        b.fly();
        ((Parrot)b).speak();

        Bird[] arr = new Bird[]{p3, p4, p5, new Parrot()};
        for(int i = 0; i < arr.length; i++){
            arr[i].fly(); // полимофизм
        }

        Bird.printCount();
        b.printCount();
         */

        Bird b1 = new Parrot();
        //Bird b2 = b1;
        Bird b2 = new Penguin();

        BirdsTeam team = new BirdsTeam();
        team.add(b1);
        team.add(b2);

        //MyFrame mf = new MyFrame(b2);
        MyFrame mf = new MyFrame(team);

        Parrot.printCount();
        Penguin.printCount();
        Sparrow.printCount();
    }
}
