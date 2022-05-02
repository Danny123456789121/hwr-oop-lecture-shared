package hwr.oop.exercises.gameoflife;

public class Cell {

    boolean alive;
    Position position;
    Cell[] neighbours = new Cell[8];

    public Cell(int x, int y) {
        this.position = new Position(x,y);
    }

    Position getPosition() {
        return position;
    }

    Cell[] getNeighbours(){
        for (int i = 0; i < neighbours.length ; i++) {
            for (int x = position.x - 1; x <= position.y + 1; x++) {
                for (int y = position.y - 1; y <= position.y + 1; y++) {
                    if (x != position.x && y != position.y && !outOfGrid(x, y)) {
                        neighbours[i] = new Cell(x, y);
                    }
                }
            }
        }
        return neighbours;
    }

    boolean outOfGrid(int x, int y){
        return (x < 0 || x > 9) || (y < 0 || y > 9);
    }

    boolean isAlive(){
        return alive;
    }

    boolean isDead(){
        return alive;
    }

    boolean isAliveNextGeneration(){
        return neighbours.length >= 2 && neighbours.length <= 3;
    }

    void markAlive(){
        alive = true;
    }

    void markDead(){
        alive = false;
    }
}
