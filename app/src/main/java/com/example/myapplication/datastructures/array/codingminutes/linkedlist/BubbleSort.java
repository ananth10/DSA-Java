package com.example.myapplication.datastructures.array.codingminutes.linkedlist;

public class BubbleSort {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addBack(10);
        list.addBack(30);
        list.addBack(20);
        list.addBack(5);
        list.print();
        System.out.println();
        LinkedList<Integer> sortedList = bubbleSort(list);
        sortedList.print();
    }

    static LinkedList<Integer> bubbleSort(LinkedList<Integer> list) {

        Node currentNode = list.getBegin();

        while (currentNode != null) {
            Node node = list.getBegin();
            while (node.next != null) {
                int currentNodeData = (int) node.data;
                int nextNodeData = (int) node.next.data;
                if (currentNodeData > nextNodeData) {
                    int temp = (int) node.data;
                    node.data = nextNodeData;
                    node.next.data = temp;
                }
                node = node.next;
            }
            currentNode = currentNode.next;
        }

        return list;
    }
}
