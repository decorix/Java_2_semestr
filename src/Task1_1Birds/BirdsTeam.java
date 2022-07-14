package Task1_1Birds;

import java.awt.*;
import java.util.ArrayList;

public class BirdsTeam {
    private ArrayList<Bird> birds;

    public BirdsTeam(){
        birds = new ArrayList<Bird>();
    }

    public void add(Bird b){
        birds.add(b);
    }

    public void draw(Graphics g){
        for(int i = 0; i < birds.size(); i++){
            birds.get(i).draw(g);
        }
    }
}
