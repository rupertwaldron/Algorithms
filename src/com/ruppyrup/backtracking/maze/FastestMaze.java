package com.ruppyrup.backtracking.maze;

import java.util.Deque;
import java.util.LinkedList;

public class FastestMaze {

    private char[][] grid;

    int rowNbr[] = new int[]{-1, 0, 0, 1};
    int colNbr[] = new int[]{0, -1, 1, 0};

    int count;
    private int ROW;
    private int COL;

    private GridReference finish;

    public boolean solveMaze(char[][] board, int startrow, int startcol, int finishrow, int finishcol) {
        this.grid = board;
        ROW = grid.length;
        COL = grid[0].length;
        finish = new GridReference(finishrow, finishcol);
        GridReference start = new GridReference(startrow, startcol);
        BFS(start);
        return DFS(startrow, startcol);

    }


    private boolean BFS(GridReference gridReference) {


        Deque<GridReference> queue = new LinkedList<>();
        queue.push(gridReference);
        while (!queue.isEmpty()) {
            GridReference currentGrid = queue.removeFirst();

            int row = currentGrid.rowIndex;
            int col = currentGrid.colIndex;

            if (currentGrid.equals(finish)) {
                grid[row][col] = '*';
                return true;
            }

            grid[row][col] = '*';


            for (int k = 0; k < 4; ++k) {
                if (isSafe(row + rowNbr[k], col + colNbr[k], '1')) {
                    System.out.println(row + " : " + col);
                    queue.addLast(new GridReference(row + rowNbr[k], col + colNbr[k]));
                }
            }
        }
        return false;
    }


    private boolean DFS(int row, int col) {
        if (row == finish.rowIndex && col == finish.colIndex) {
            grid[row][col] = 'X';
            return true;
        }



        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k) {
            if (isSafe(row + rowNbr[k], col + colNbr[k], '*')) {
                grid[row][col] = 'X';
                if (DFS(row + rowNbr[k], col + colNbr[k])) {
                    return true;
                } else {
                    //backtrack
                    grid[row][col] = '*';
                }
            }


        }

        return false;

    }

    static class GridReference {
        int rowIndex;
        int colIndex;

        public GridReference(final int rowIndex, final int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final GridReference that = (GridReference) o;

            if (rowIndex != that.rowIndex) return false;
            return colIndex == that.colIndex;
        }

        @Override
        public int hashCode() {
            int result = rowIndex;
            result = 31 * result + colIndex;
            return result;
        }
    }

    boolean isSafe(int row, int col, char symbol) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW)
                && (col >= 0) && (col < COL)
                && (grid[row][col] == symbol);
    }


    private void printGrid(char[][] board) {
        int col = board.length;
        int row = board[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'1', '1', '1', '1', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '0', '0', '1', '1'},
                {'0', '1', '0', '1', '1', '1', '0', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '0', '0', '1'},
        };


        FastestMaze mazeSolvers = new FastestMaze();
        System.out.println("Number of islands = " + mazeSolvers.solveMaze(maze, 0, 0, 7, 7));
        mazeSolvers.printGrid(maze);

    }

}
