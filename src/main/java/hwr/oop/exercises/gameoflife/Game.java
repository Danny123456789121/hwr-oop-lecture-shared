package hwr.oop.exercises.gameoflife;

public class Game {
    Field field;

    public Game(Field field) {
        this.field = field;
    }

    void proceed(){

        for(Cell[] cA : field.cells){
            for (Cell c: cA) {
                if (c.isAliveNextGeneration()) {
                    c.markAlive();
                } else
                    c.markDead();
            }
        }
    }
}
