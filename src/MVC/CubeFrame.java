package MVC;

import MVC.Cube;

import javax.swing.*;
import java.awt.*;


public class CubeFrame extends JFrame{
    public static final int width = 700;
    public static final int height = 700;
    private Cube cube;

    public CubeFrame(Cube cube){
        start();
        this.cube = cube;
    }

    private void start(){
        this.setSize(width, height);
        this.setTitle("Cube");
        this.setLocation(800, 200);
        this.setVisible(true); // --> paint(g)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D) g;
        BasicStroke pen1 = new BasicStroke(2); //толщина линии 20
        gr.setStroke(pen1);
        g.clearRect(0, 0, width, height);

        super.paint(g);
        g.translate(width/2, height/2);
        g.drawLine(-width/2, 0, width/2, 0);
        g.drawLine(0, height/2, 0, -height/2);

        cube.ortDraw(g);
    }
}