package com.ruppyrup.backtracking.islands;

public class Islands {

    private char[][] grid;

    private boolean[][] visited;

    int count;
    private int ROW;
    private int COL;

    public int numIslands(char[][] board) {
        this.grid = board;
        ROW = grid.length;
        COL = grid[0].length;
        visited = new boolean[ROW][COL];

        for (int rowIndex = 0; rowIndex < ROW; rowIndex++) {
            for (int colIndex = 0; colIndex < COL; colIndex++) {

                if ('1' == grid[rowIndex][colIndex] && !visited[rowIndex][colIndex]) {
                    System.out.println("Found more island at " + rowIndex + " : " + colIndex);

                    DFS(rowIndex, colIndex);
                    ++count;
                }
            }
        }
        return count;
    }


    private void DFS(int row, int col) {

        System.out.println("Trying previous => " + row + " : " + col);
        int rowNbr[] = new int[]{-1, 0, 0, 1};
        int colNbr[] = new int[]{0, -1, 1, 0};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k)
            if (isSafe(row + rowNbr[k], col + colNbr[k]))
                DFS(row + rowNbr[k], col + colNbr[k]);

    }

    boolean isSafe(int row, int col) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW)
                && (col >= 0) && (col < COL)
                && (grid[row][col] == '1'
                && !visited[row][col]);
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
        char[][] map = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] map2 = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '1'},
                {'0', '0', '1', '1', '0'}
        };

        char[][] map3 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };


        Islands islands = new Islands();
        System.out.println("Number of islands = " + islands.numIslands(map3));
        islands.printGrid(map3);

    }

}
