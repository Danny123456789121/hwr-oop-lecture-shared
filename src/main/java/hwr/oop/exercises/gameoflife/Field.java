package hwr.oop.exercises.gameoflife;

public class Field {

    Cell[][] cells;

    public Field(int size) {
        cells = new Cell[size][size];
        fillCells();
    }

    Cell getCellAt(Position position){
        return cells[position.x][position.y];
    }

    void fillCells(){
        for (int x = 0; x < cells.length ; x++) {
            for (int y = 0; y < cells.length; y++) {
                cells[x][y] = new Cell(x,y);
            }

        }
    }
}
