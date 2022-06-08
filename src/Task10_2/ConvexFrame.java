package Task10_2;

import javax.swing.*;
import java.awt.*;

public class ConvexFrame extends JFrame{
    private static final int size = 400;
    private Convex convex;

    public ConvexFrame(Convex convex){
        start();
        this.convex = convex;
    }

    private void start(){
        this.setSize(size,size);
        this.setTitle("Convex");
        this.setLocation(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);

        g.translate(size/2, size/2);
        g.drawLine(-size/2, 0, size/2, 0);
        g.drawLine(0, size/2, 0, -size/2);

        convex.draw(g);
    }
}
