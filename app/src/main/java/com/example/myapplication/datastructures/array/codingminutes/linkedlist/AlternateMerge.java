package com.example.myapplication.datastructures.array.codingminutes.linkedlist;

public class AlternateMerge {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList();
        list1.addBack(5);
        list1.addBack(7);
        list1.addBack(17);
        list1.addBack(13);
        list1.addBack(11);
        list1.print();
        LinkedList<Integer> list2 = new LinkedList();
        list2.addBack(12);
        list2.addBack(10);
        list2.addBack(2);
        list2.addBack(4);
        list2.addBack(6);
        list2.print();

        Node result = alternateMerge(list1.getBegin(), list2.getBegin());
        System.out.println("result:" + result);

    }


    public static Node alternateMerge(Node root1, Node root2) {
        Node root = null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        while (root1 != null && root2 != null) {
            root = appendNode(root, (Integer) root1.data);
            root = appendNode(root, (Integer) root2.data);
            root1 = root1.next;
            root2 = root2.next;
        }

        if (root1 != null) {
            while (root1 != null) {
                root = appendNode(root, (Integer) root1.data);
                root1 = root1.next;
            }
        }
        if (root2 != null) {
            while (root2 != null) {
                root = appendNode(root, (Integer) root2.data);
                root2 = root2.next;
            }
        }

        return root;
    }

    public static Node appendNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return root;
    }
}


