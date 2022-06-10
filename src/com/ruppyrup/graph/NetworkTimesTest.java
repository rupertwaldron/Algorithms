package com.ruppyrup.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTimesTest {


    private NetworkTimes networkTimes;

    @BeforeEach
    void setUp() {
        networkTimes = new NetworkTimes();
    }

    @Test
    void checkExample1() {
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
        int n = 3, k = 2;
        int result = networkTimes.networkDelayTime(times, n, k);
        assertEquals(-1, result);
    }

    @Test
    void checkExample2() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {1, 5, 2}};
        int n = 5, k = 2;
        int result = networkTimes.networkDelayTime(times, n, k);
        assertEquals(3, result);
    }

    @Test
    void checkExample3() {
        int[][] times = {{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}};
        int n = 4, k = 1;
        int result = networkTimes.networkDelayTime(times, n, k);
        assertEquals(-1, result);
    }

}
