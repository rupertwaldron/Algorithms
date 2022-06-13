package com.ruppyrup.backtracking.maze;

public class Maze {

    private char[][] grid;

    int rowNbr[] = new int[]{-1, 0, 0, 1};
    int colNbr[] = new int[]{0, -1, 1, 0};

    int count;
    private int ROW;
    private int COL;

    private int finishrow;
    private int finishcol;

    public boolean solveMaze(char[][] board, int startrow, int startcol, int finishrow, int finishcol) {
        this.grid = board;
        ROW = grid.length;
        COL = grid[0].length;
        this.finishrow = finishrow;
        this.finishcol = finishcol;

        return DFS(startrow, startcol);
    }


    private boolean DFS(int row, int col) {
        if (row == finishrow && col == finishcol) {
            grid[row][col] = '*';
            return true;
        }



        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k) {
            if (isSafe(row + rowNbr[k], col + colNbr[k])) {
                grid[row][col] = '*';
                if (DFS(row + rowNbr[k], col + colNbr[k])) {
                    return true;
                } else {
                    //backtrack
                    grid[row][col] = '1';
                }
            }


        }

        return false;

    }

    boolean isSafe(int row, int col) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW)
                && (col >= 0) && (col < COL)
                && (grid[row][col] == '1');
    }


    private void printGrid(char[][] board) {
        int col = board.length;
        int row = board[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1'}
        };


        Maze mazeSolvers = new Maze();
        System.out.println("Number of islands = " + mazeSolvers.solveMaze(maze, 0, 0, 3, 3));
        mazeSolvers.printGrid(maze);

    }

}
