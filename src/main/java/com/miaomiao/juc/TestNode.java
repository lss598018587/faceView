package com.miaomiao.juc;

public class TestNode {
    static Node tail = null;
    static Node head = null;

    public static void main(String[] args) {
        Node node = new Node("t2");
        for (; ; ) {
            Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new Node("t1")))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    break;
                }
            }
        }
        System.out.println("结束");
        System.out.println(node);
    }

    public static boolean compareAndSetHead(Node node) {
        head = node;
        return true;
    }
    public static boolean compareAndSetTail(Node oldNode,Node newNode) {
        if(tail == oldNode){
            tail = newNode;
            return true;
        }
        return false;
    }
}

class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    Node prev;
    Node next;

    public String getName() {
        return name;
    }


}
