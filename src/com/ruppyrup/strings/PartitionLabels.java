package com.ruppyrup.strings;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PartitionLabels {


    public List<Integer> partitionLabels(String s) {
        if (s.length() == 0) return List.of();
        if (s.length() == 1) return List.of(1);

        List<Integer> splits = new ArrayList<>();
        Deque<Character> start = new LinkedList<>();
        Deque<Character> end = new LinkedList<>();

        for (char c : s.toCharArray()) {
            end.push(c);
        }

        List<Character> temp = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            temp.add(letter);
            start.push(letter);
            end.removeLast();

            Set<Character> startSet = new HashSet<>(start);
            startSet.retainAll(new HashSet<>(end));


            if (!end.contains(letter) && startSet.isEmpty()) {
                splits.add(temp.size());
                System.out.println(temp);
                temp.clear();
            }
        }

        return splits;
    }


}



