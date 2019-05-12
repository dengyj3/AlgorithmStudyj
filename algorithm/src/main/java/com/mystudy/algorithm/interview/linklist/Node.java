package com.mystudy.algorithm.interview.linklist;

public class Node {
    private int value;
    private Node next;
    Node(int data){
        this.value = data;
    }

    public void printCommonPart(Node head1, Node head2){
        System.out.println("Common Part : ");
        while (head1 != null && head2 != null){
            if (head1.value != head2.value){
                head1 = head1.next;
            }else if (head1.value > head2.value){
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public Node removeLastKthNode(Node head, int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
        }
        if (lastKth<0){
            cur = head;
            while (++lastKth!=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(7);

        Node head2 = new Node(5);
        head2.next = new Node(6);

//        head1.printCommonPart(head1, head2);

        head1.removeLastKthNode(head1,5);
        head1.removeLastKthNode(head1,4);
        head1.removeLastKthNode(head1,3);
    }
}
