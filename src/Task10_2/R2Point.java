package Task10_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class R2Point {
    public int x, y;

    public R2Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public R2Point() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("x -> ");
        x = in.nextInt();
        System.out.print("y -> ");
        y = in.nextInt();
        try{
            FileWriter fw = new FileWriter("test.txt", true);
            fw.write(x + " " + y);
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double dist(R2Point a, R2Point b){
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }

    public static double area(R2Point a, R2Point b, R2Point c){
        return 0.5*((a.x - c.x)*(b.y - c.y) - (a.y - c.y)*(b.x - c.x));
    }

    public static boolean equal(R2Point a, R2Point b){
        return a.x == b.x && a.y == b.y;
    }

    public static boolean isTriangle(R2Point a, R2Point b, R2Point c){
        return area(a, b, c) != 0.0;
    }

    public boolean inside(R2Point a, R2Point b){
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x)&&(a.y <= y && y <= b.y || a.y >= y && y >= b.y);
    }

    public boolean light(R2Point a, R2Point b){
        double s = area(a, b, this);
        return s < 0.0 || (s == 0.0 && !inside(a, b));
    }
}
