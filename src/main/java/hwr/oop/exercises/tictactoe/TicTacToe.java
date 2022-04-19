package hwr.oop.exercises.tictactoe;

import java.util.Arrays;

class TicTacToe {

    int[][] squares;
    boolean crossSet;
    boolean circleSet;
    int pointsA;
    int pointsB;

    TicTacToe() {
        squares = new int[3][3];
    }
    int getValueAt(int x, int y) {
        return squares[x][y];
    }

    public void setCross(int x, int y) {
            if (isGameOver()) {
                throw new RuntimeException("Game is over!");
            } else if (squares[x][y] == 0 && getValueAt(x,y) == 0 && !crossSet) {
                squares[x][y] = 1;
                crossSet = true;
                circleSet = false;
            } else throw new RuntimeException("tried to check same square twice");

    }

    public void setCircle(int x, int y) {
            if (isGameOver()) {
                throw new RuntimeException("Game is over!");
            } else if (squares[x][y] == 0 && getValueAt(x,y) == 0 && !circleSet) {
                squares[x][y] = 2;
                circleSet = true;
                crossSet = false;
            } else throw new RuntimeException("tried to check same square twice");
    }

    public boolean isGameOver() {

        if(crossWon() || circleWon() || tie()){
            System.out.println("Points A: " + pointsA + " Points B: " + pointsB);
            return true;
        }
        return false;
    }

    private boolean crossWon(){
        for (int x = 0; x < 3; x++) {
            if (squares[x][0] == 1 && squares[x][1] == 1 && squares[x][2] == 1){
                pointsA++;
                return true;
            }
        }
        for (int y = 0; y < 3; y++) {
            if (squares[0][y] == 1 && squares[1][y] == 1 && squares[2][y] == 1) {
                pointsA++;
                return true;
            }
        }
        if (squares[0][0] == 1 && squares[1][1] == 1 && squares[2][2] == 1 || squares[0][2] == 1 && squares[1][1] == 1 && squares[2][0] == 1){
            pointsA++;
            return true;
        }
        return false;
    }

    private boolean circleWon(){
        for (int x = 0; x < 3; x++) {
            if (squares[x][0] == 2 && squares[x][1] == 2 && squares[x][2] == 2) {
                pointsB++;
                return true;
            }
        }
        for (int y = 0; y < 3; y++) {
            if (squares[0][y] == 2 && squares[1][y] == 2 && squares[2][y] == 2){
                pointsB++;
                return true;
            }
        }
        if (squares[0][0] == 2 && squares[1][1] == 2 && squares[2][2] == 2 || squares[0][2] == 2 && squares[1][1] == 2 && squares[2][0] == 2){
            pointsB++;
            return true;
        }
        return false;
    }

    private boolean tie(){
        for (int[] a: squares) {
            for (int elem: a) {
                if(elem == 0)
                    return false;
            }
        }
        return true;
    }

    void resetBoard(){
        for (int[] a: squares){
            Arrays.fill(a, 0);
        }
    }
}
