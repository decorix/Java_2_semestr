package Task10_2;

import java.awt.*;

public class Convex {
    private Figure fig;

    public Convex(){
        fig = new Void();
    }

    public void add(R2Point p){
        fig = fig.add(p);
    }

    public double area(){
        return fig.area();
    }

    public void draw(Graphics g) {
        fig.draw(g);
    }

    public double perimeter(){
        return fig.perimeter();
    }
}
