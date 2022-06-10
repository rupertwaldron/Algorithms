package com.ruppyrup.lrucache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {


    @Test
    void canAddToCacheAndRetreive() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        int result = cache.get(1);
        assertEquals(1, result);
    }

    @Test
    void returnsErrorIfKeyDoesNotExist() {
        LRUCache cache = new LRUCache(2);
        int result = cache.get(1);
        assertEquals(-1, result);
    }

    @Test
    void cacheWillEvictOldestKeyIfOverCapacity() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        int result = cache.get(1);
        assertEquals(-1, result);
    }

    @Test
    void cacheWillEvitLRUKeyIfOverCapacity() {
        LRUCache cache = new LRUCache(2);
        cache.put(4, 4);
        cache.put(2, 2);
        cache.get(4);
        cache.put(3, 3);
        int result = cache.get(2);
        assertEquals(-1, result);
    }

    @Test
    void leetCodeTest() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void leetCodeTest2() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }
}
