package com.ruppyrup.backtracking.colouring;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {

    private final int[][] map;
    private final Map<Integer, Integer> colorVertices;
    private Map<Integer, String> colorRef;

    private final int verticesCount;

    public ColorMap(final int[][] map) {
        this.map = map;
        verticesCount = map.length;
        colorVertices = new HashMap<>();
    }


    public Map<Integer, String> solve(final int numColors) {
        colorRef = Map.of(
                0, "Red",
                1, "Blue",
                2, "Yellow",
                3, "Green",
                4, "Orange"
        );

        Map<Integer, String> finalMap = new HashMap<>();

        solveColor(0);

        colorVertices.forEach((key, value) -> finalMap.put(key, colorRef.get(value)));

        return finalMap;

    }


    private boolean solveColor(int startrow) {
        if (!assignColor(startrow)) return false;

        if (colorVertices.size() == verticesCount) {
            return true;
        }


        for (int col = 0; col < verticesCount; col++) {
            if (colorVertices.containsKey(col)) continue;

            if (map[startrow][col] == 1) {
                if (solveColor(col)) {
                    return true;
                }

                //back track

                colorVertices.remove(startrow);
            }

        }
        return false;
    }

    private boolean assignColor(final int vertex) {
        for (int color : colorRef.keySet()) {
            if (isColorValid(vertex, color)) {
                colorVertices.put(vertex, color);
                return true;
            }
        }
        return false;
    }

    private boolean isColorValid(final int vertex, final int color) {
        for (int col = 0; col < verticesCount; col++) {
            if (map[vertex][col] == 1 && colorVertices.containsKey(col) && colorVertices.get(col) == color) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1, 0, 0},  //a
                {1, 0, 1, 0, 1, 0},  //b
                {1, 1, 0, 1, 0, 1},  //c
                {1, 0, 1, 0, 0, 1},  //d
                {0, 1, 0, 0, 0, 1},  //e
                {0, 1, 1, 1, 1, 0}   //f
        };
        ColorMap colorMap = new ColorMap(matrix);

        System.out.println(colorMap.solve(5));

    }
}
