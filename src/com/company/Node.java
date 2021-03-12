package com.company;

public class Node {

    int data;
    Node next;
    Node prev;

    //LinkNode nodeA = new LinkNode(data);
    //LinkNode nodeB = new LinkNode(data);
    //nodeA.next = nodeB    forbinder to noder, da deres next er NULL på denne constructor.

    Node(){

    }

    Node(int data){
        this.data=data;
    }



    public static int countNodes(Node head){
        int count =0;
        Node current = head;
        while (current.next != null){
            current = current.next;
            count++;
        }
        return count;
    }



}
