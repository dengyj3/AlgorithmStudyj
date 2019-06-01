package com.mystudy.algorithm.tree;

import java.util.Stack;

public class VisitTree {
    public static void preOrderRecur(Node1 head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void preOrderUnRecur(Node1 head) {
        System.out.print("pre-order : ");
        if (head != null) {
            Stack<Node1> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderRecur(Node1 head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void inOrderUnRecur(Node1 head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node1> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node1 head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node1> stack1 = new Stack<>();
            Stack<Node1> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderRecur(Node1 head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);
        preOrderRecur(root);
        System.out.println("\n===========");
        inOrderRecur(root);
        System.out.println("\n===========");
        posOrderRecur(root);
        System.out.println("\n+++++++++++");
        preOrderUnRecur(root);
        System.out.println("\n+++++++++++");
        inOrderUnRecur(root);
        System.out.println("\n+++++++++++");
        posOrderUnRecur1(root);
    }
}
