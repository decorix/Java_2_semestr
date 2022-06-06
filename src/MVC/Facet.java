package MVC;

import MVC.R3Vector;

import java.awt.*;
import java.awt.geom.Path2D;


public class Facet { //грань
    private R3Vector[] vertex;
    private Color color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4) {
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;

        color = Color.BLACK;
    }

    public void scale(double k) {
        for (int i = 0; i < 4; i++) {
            vertex[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < 4; i++) {
            vertex[i].translate(dx, dy, dz);
        }
    }

    public void rotate(double ux, double uy, double uz) {
        for (int i = 0; i < 4; i++) {
            vertex[i].rotate(ux, uy, uz);
        }
    }

    public void ortDraw(Graphics g){
        Path2D p = new Path2D.Double();
        p.moveTo(vertex[0].getX(), vertex[0].getY());
        p.lineTo(vertex[1].getX(), vertex[1].getY());
        p.lineTo(vertex[2].getX(), vertex[2].getY());
        p.lineTo(vertex[3].getX(), vertex[3].getY());
        p.lineTo(vertex[0].getX(), vertex[0].getY());
        p.closePath();

        g.setColor(color);
        ((Graphics2D) g).draw(p);
        //((Graphics2D) g).fill(p);
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
