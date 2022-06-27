package com.ruppyrup.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeChecker {

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (root.value > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private static void printTree(Node root) {
        if (root == null) return;
        Deque<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.removeFirst();
            if (currentNode.left != null) nodes.addLast(currentNode.left);
            if (currentNode.right != null) nodes.addLast(currentNode.right);
            System.out.println(currentNode.value);
        }
    }

    // input
    // 4, 7, 2, 8, 1, 6, 5, 3


    // 1, 2, 3, 4, 5, 6, 7, 8 - get an ordered list
    private static void inOrderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.add(root.value);
        inOrderTraversal(root.right, list);
    }

    // 4, 2, 1, 3, 7, 6, 5, 8  - inspect nodes first - copy the tree
    private static void preOrderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.value);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    // 1, 3, 2, 4, 5, 6, 8, 7, 4 // inspect the leaves first - e.g. delete the tree from leaf to root
    private static void postOrderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.value);
    }

    // 4, 2, 7, 1, 3, 6, 8, 5 // inspect the shortest path
    private static void breadthFirst(Node root, List<Integer> list) {
        if (root == null) return;
        Deque<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();
            list.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println("*** Printing Tree ****");
        printTree(root);

        System.out.println("Inorder traversal");
        List<Integer> tree = new ArrayList<>();
        inOrderTraversal(root, tree);
        System.out.println(tree);

        System.out.println("Preorder traversal");
        List<Integer> tree2 = new ArrayList<>();
        preOrderTraversal(root, tree2);
        System.out.println(tree2);

        System.out.println("Postorder traversal");
        List<Integer> tree3 = new ArrayList<>();
        postOrderTraversal(root, tree3);
        System.out.println(tree3);

        System.out.println("Breadth first search");
        List<Integer> tree4 = new ArrayList<>();
        breadthFirst(root, tree4);
        System.out.println(tree4);

    }
}


class Node {
    Node left;
    Node right;
    int value;

    public Node(final int value) {
        this.value = value;
    }
}
