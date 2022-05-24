package hwr.oop.exercises.gameoflife;

public class Cell {

    boolean alive;
    Position position;
    Field field;

    public Cell(Position position, Field field) {
        this.position = position;
        this.field = field;
    }

    Position getPosition() {
        return position;
    }

    public Cell[] getNeighbours() {
        Position[] pos = position.getNeighbourPositions();
        Cell[] neighbours = new Cell[pos.length];
        for (int i = 0; i < pos.length; i++)
            neighbours[i] = field.getCellAt(pos[i]);
        return neighbours;
    }

    boolean isAlive() {
        return alive;
    }

    boolean isDead() {
        return !alive;
    }

    boolean isAliveNextGeneration() {
        Cell[] neighbours = getNeighbours();
        int activeCells = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.isAlive()) {
                activeCells++;
            }
        }

        //System.out.println(activeCells);
        if (isAlive() && (activeCells == 2 || activeCells == 3)) {
            System.out.println(activeCells);

            System.out.println("yes");
            return true;
        }
        if (isAlive() && (activeCells<2 || activeCells>3)) {
            System.out.println(activeCells);

            System.out.println("yes2");
            return false;
        }
        if (isDead() && (activeCells == 3)) {
            System.out.println(activeCells);

            System.out.println("yes3");
            return true;
        }
        return false;
    }

    void markAlive() {
        alive = true;
    }

    void markDead() {
        alive = false;
    }

}
