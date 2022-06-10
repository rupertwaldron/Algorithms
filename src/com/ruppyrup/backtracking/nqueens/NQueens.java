package com.ruppyrup.backtracking.nqueens;

public class NQueens {
    private int[][] chessBoard;
    private int numOfQueens;

    public NQueens(int numOfQueens) {
        chessBoard = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    public void solve() {
        // check for final solution
        // use for loop to alter the position of the first queen place
        // to get all possible solutions
        for (int i = 0; i < chessBoard.length; i++) {
            if (setQueens(0, i)) {
                printQueens();
                System.out.println("----------------------------");
            } else {
                System.out.println("There is no solution....");
            }
            chessBoard = new int[numOfQueens][numOfQueens];
        }
    }

    private boolean setQueens(int colIndex, int start) {
        if (colIndex == numOfQueens) {
            return true;
        }
        int startRow = 0;
        if (colIndex == 0) {
            startRow = start;
        }
        for (int rowIndex = startRow; rowIndex < chessBoard.length; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;

                if(setQueens(colIndex + 1, 0)) {
                    return  true;
                }
                //Now entering back tracking
                chessBoard[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (chessBoard[rowIndex][i] == 1) {
                return false;
            }
        }
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = colIndex; i < numOfQueens && j >= 0; i++, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private void printQueens() {
        int boardDim = chessBoard.length;
        for (int i = 0; i < boardDim; i++) {
            for (int j = 0; j < boardDim; j++) {
                if (chessBoard[i][j] == 1) { //if queen
                    System.out.print(" 🦹 ");
                } else {
                    System.out.print(" 🎱 ");
                }
            }
            System.out.println();
        }
    }
}
