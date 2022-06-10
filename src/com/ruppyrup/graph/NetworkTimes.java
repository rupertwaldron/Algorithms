package com.ruppyrup.graph;

import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class NetworkTimes {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int key1 = times[i][0];
            int key2 = times[i][1];
            int edgeValue = times[i][2];
            nodes.computeIfAbsent(key1, Node::new);
            nodes.computeIfAbsent(key2, Node::new);
            if (key2 != k) {
                nodes.get(key1).addEdge(new Node.Edge(nodes.get(key2), edgeValue));
            }

        }

        Deque<Node.Edge> searchNodes = new LinkedList<>();

        nodes.get(k).connections.forEach(searchNodes::push);

        Map<Integer, Integer> timeDelay = nodes.keySet().stream()
                .filter(key -> key != k)
                .collect(Collectors.toMap(
                        id -> id, id -> -1
                ));

        navigateGraph(nodes.get(k), timeDelay, 0);
        System.out.println(timeDelay);

        timeDelay.remove(k);

        if (timeDelay.values().contains(-1)) return -1;

        Optional<Map.Entry<Integer, Integer>> max = timeDelay.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

        return max.get().getValue();
    }

    private void navigateGraph(Node node, Map<Integer, Integer> map, int currentDelay) {
        for (Node.Edge edge : node.connections) {
            int newDelay = edge.edgeValue + currentDelay;
            if (map.get(edge.node.id) > newDelay || map.get(edge.node.id) == -1) {
                map.put(edge.node.id, newDelay);
            }
            navigateGraph(edge.node, map, newDelay);
        }
    }

    public static void main(String[] args) {
//        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {1, 5, 2}};
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 1}};
        int n = 3, k = 2;
//        int n = 5, k = 2;

        NetworkTimes networkTimes = new NetworkTimes();
        int result = networkTimes.networkDelayTime(times, n, k);
        System.out.println("Result = " + result);
    }

    static class Node {

        Set<Edge> connections = new HashSet<>();
        int id;

        public Node(final int id) {
            this.id = id;
        }

        public void addEdge(Edge edge) {
            connections.add(edge);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Node node = (Node) o;

            return id == node.id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        static class Edge {
            Node node;
            int edgeValue;

            public Edge(final Node node, final int edgeValue) {
                this.node = node;
                this.edgeValue = edgeValue;
            }
        }
    }


}
