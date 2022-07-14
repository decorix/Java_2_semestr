package Task1_2Birds;

import java.awt.*;

public class Parrot extends Bird { // наследование
    private String name = "Кеша"; // пример переменной экземпяра класса

    public Parrot(){
        System.out.println("Я попугай.");

        size = 10;
        color = new Color(0, 255, 0);
    }

    public Parrot(String name){ // перегрузка конструктора
        this.name = name;
        System.out.println("Я попугай.");
    }

    public void speak(){
        System.out.println("Меня зовут " + name + ".");
    }

    //public void rename(String name){
    //    this.name = name;
    //}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void hello(Penguin p){
        System.out.println("Привет пингвин! Я попугай " + name + ".");
    }

    public void hello(Parrot p){
        System.out.println("Привет попугай " + p.name + "! Я попугай " + this.name + ".");
    }
}
