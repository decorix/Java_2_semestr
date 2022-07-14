package Task1_2Birds;

import java.awt.*;
import java.util.ArrayList;

public class BirdsTeam extends ArrayList<Bird> {
    //private ArrayList<Bird> birds;

    public BirdsTeam(){
        super();
    }

    public void append(Bird b){
        super.add(b);
    }

    public void draw(Graphics g){
        for(int i = 0; i < this.size(); i++){
            this.get(i).draw(g);
        }
    }
}
