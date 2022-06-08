package Task10_2;

import java.awt.*;
import java.util.ArrayDeque;

public class Polygon extends ArrayDeque implements Figure{
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        addFirst(b);

        if (b.light(a, c)){
            addFirst(a);
            addLast(c);
        }
        else{
            addFirst(c);
            addLast(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = size(); i > 0 && !t.light((R2Point) getLast(), (R2Point) getFirst()); i--)
            addLast(removeFirst());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow((R2Point) getLast(), (R2Point) getFirst(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = (R2Point) removeFirst(); t.light(x, (R2Point) getFirst()); x = (R2Point) removeFirst())
                grow(x, (R2Point) getFirst(), t);
            addFirst(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = (R2Point) removeLast(); t.light((R2Point) getLast(), x); x = (R2Point) removeLast())
                grow((R2Point) getLast(), x, t);
            addLast(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist((R2Point) getLast(), t) + R2Point.dist(t, (R2Point) getFirst());
            addFirst(t);
        }

        return this;
    }

    public void draw(Graphics g) {
        R2Point first = (R2Point) getFirst();
        R2Point last = (R2Point) getLast();
        g.drawLine(first.x, -first.y, last.x, -last.y);
        R2Point proshloe = first;
        int size = size();

        for (int i = 0; i < size; i++) {
            R2Point now = (R2Point) removeFirst();
            addLast(now);
            g.fillOval(now.x - 4/2, -now.y - 4/2, 4, 4);
            g.drawLine(now.x, -now.y, proshloe.x, -proshloe.y);
            proshloe = now;
        }

    }
}
