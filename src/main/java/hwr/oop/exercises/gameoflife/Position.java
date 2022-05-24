package hwr.oop.exercises.gameoflife;

import java.sql.SQLOutput;
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
                 if(this.x == position.x + x && this.y == position.y + y)
                     return true;
            }
        }
        return false;
    }

    Position[] getNeighbourPositions(){
        int count = 0;
        Position[] neighbours = new Position[100];
            for (int x = this.x - 1; x <= this.x + 1; x++) {
                for (int y = this.y - 1; y <= this.y + 1; y++) {
                    if (isNextTo(this) && !outOfGrid(x,y) && !this.equals(new Position(x,y))) {
                        neighbours[count] = new Position(x,y);
                        count++;
                    }
                }
            }
        return cropNeighbours(neighbours);
    }

    boolean outOfGrid(int x, int y){
        return (x < 0 || x > 9) || (y < 0 || y > 9);
    }

    Position[] cropNeighbours(Position[] c){
        return Arrays.stream(c).filter(Objects::nonNull).toArray(Position[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
