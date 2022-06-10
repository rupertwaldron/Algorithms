package com.ruppyrup.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache {

    private final FixedMap store;

    public LRUCache(int capacity) {
        store = new FixedMap(capacity);
    }

    public int get(int key) {
        Integer result = Optional.ofNullable(store.get(key)).orElse(-1);
        if (result != -1) {
            store.remove(key);
            store.put(key, result);
        }
        return result;
    }

    public void put(int key, int value) {
        Integer result = Optional.ofNullable(store.get(key)).orElse(-1);
        if (result != -1) {
            store.remove(key);
            store.put(key, value);
        } else {
            store.put(key, value);
        }
    }

    class FixedMap extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        public FixedMap(int capacity) {
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(final Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }

}
