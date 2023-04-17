package com.example.myapplication.datastructures.array.codingminutes.linkedlist;

public class KthLastElement {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.addBack(4);
        list.addBack(5);
        list.addBack(6);
        list.addBack(7);
        int key = 3;
        int result = kLastElement(list,key);
        System.out.println(result);

        int result1 = kLastElement2pointer(list,key);
        System.out.println(result1);
    }

    //approach one
    //(n-k+1)
    public static int kLastElement(LinkedList list, int key){
        int n = 0;
        Node currentNode = list.getBegin();
        while (currentNode!=null){
            currentNode = currentNode.next;
            n++;
        }
        System.out.println("N:"+n);
        int lastKthElement = n-key+1;
        System.out.println("K:"+lastKthElement);
        currentNode = list.getBegin();
        for(int i=1;i<lastKthElement;i++){
            currentNode = currentNode.next;
        }
        return (int) currentNode.data;
    }


    //two pointer approach

    public static int kLastElement2pointer(LinkedList<Integer> list, int k){
        Node p = list.getBegin();
        Node q = list.getBegin();

        int count = 0;

        while (count<k){
            q = q.next;
            count++;
        }

        while (q!=null){
            q = q.next;
            p = p.next;
        }

        return (int) p.data;
    }
}
