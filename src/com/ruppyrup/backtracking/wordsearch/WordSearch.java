package com.ruppyrup.backtracking.wordsearch;

public class WordSearch {

    private char[][] grid;

    public WordSearch() {
    }

    public boolean exist(char[][] board, String word) {
        this.grid = board;
        int[] previous = new int[]{-1, -1};
        return solve(word, previous);
    }


    private boolean solve(String target, int[] previous) {
        if (target.length() == 0) {
            return true;
        }

        char letter = target.charAt(0);

        System.out.println("Trying letter => " + letter);

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[0].length; colIndex++) {
                int[] current = new int[] {rowIndex, colIndex};

                if (letter == grid[rowIndex][colIndex] && isAdjacent(current, previous)) {
                    System.out.println("Found letter " + letter + " at " + rowIndex + " : " + colIndex);
                    grid[rowIndex][colIndex] = '*';
                    int[] gridPosition = new int[] {rowIndex, colIndex};

                    if (solve(target.substring(1), gridPosition)) {
                        return true;
                    }

                    // backtrack
                    grid[rowIndex][colIndex] = letter;
                }

            }
        }

        return false;

    }

    private boolean isAdjacent(int[] found, int[] previous) {
        int foundrow = found[0];
        int foundcol = found[1];
        int previousrow = previous[0];
        int previouscol = previous[1];

        if (previousrow == -1 || previouscol == -1) return true;

        if ((Math.abs(foundrow - previousrow) == 1 && foundcol == previouscol)
                || (Math.abs(foundcol - previouscol) == 1 && foundrow == previousrow)) {
            return true;
        }
        return false;
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
        char[][] words = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String target = "ABCCED";

        WordSearch wordsearch = new WordSearch();
        System.out.println(wordsearch.exist(words, target));
        wordsearch.printGrid(words);
//        Assertions.assertTrue(wordsearch.solve(target));
    }

}
