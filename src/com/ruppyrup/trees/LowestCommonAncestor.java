package com.ruppyrup.trees;

import java.util.*;

public class LowestCommonAncestor {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static Node lca(Node root, int v1, int v2) {
        Deque<Node> treePathV1 = new LinkedList<>();
        Deque<Node> treePathV2 = new LinkedList<>();
        findNode(root, v1, treePathV1);
        findNode(root, v2, treePathV2);

        while (treePathV1.size() != treePathV2.size()) {
            if (treePathV1.size() > treePathV2.size()) treePathV1.pop();
            if (treePathV1.size() < treePathV2.size()) treePathV2.pop();
        }

        Node lca = root;
        while (true) {
            if (treePathV1.peek().data == treePathV2.peek().data) {
                lca = treePathV1.pop();
                break;
            }
            treePathV1.pop();
            treePathV2.pop();
        }
        return lca;
    }

    private static int findNode(Node root, int searchValue, Deque<Node> roots) {
        if (root.data == searchValue) {
            roots.push(root);
            return searchValue;
        }
        roots.push(root);
        if (searchValue < root.data) {
            return findNode(root.left, searchValue, roots);
        } else {
            return findNode(root.right, searchValue, roots);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
