package hwr.oop.exercises.gameoflife;

public class Game {
    Field field;
    Field nextfield;

    public Game(Field field) {
        this.field = field;
        nextfield = field;
    }

    void proceed(){
    int x = 0;
    int y = 0;
        for(Cell[] cA : field.cells){
            for (Cell c: cA) {
                if (c.isAliveNextGeneration()) {
                    nextfield.cells[x][y] = field.getCellAt(new Position(x,y));
                    nextfield.getCellAt(new Position(x,y)).markAlive();
                    y++;
                } else
                    nextfield.cells[x][y] = field.getCellAt(new Position(x,y));
                    nextfield.getCellAt(new Position(x,y)).markDead();
                    y++;
            }
            x++;
            y=0;
        }
        this.field = nextfield;
    }
}
