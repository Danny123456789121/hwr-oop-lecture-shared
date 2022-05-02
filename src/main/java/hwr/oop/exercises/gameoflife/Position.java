package hwr.oop.exercises.gameoflife;

import java.util.*;

public class Position {

    int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isNextTo(Position position){
        for(int x=-1;x<2;x++){
            for(int y=-1;y<2;y++){
                 if(this.x == position.x + x && this.y == position.y +y)
                     return true;
            }
        }
        return false;
    }
}
