package com.company;

public class Node<E> {

    E data;
    Node<E> next;
    Node prev;

    //Node nodeA = new LinkNode(data);
    //Node nodeB = new LinkNode(data);
    //nodeA.next = nodeB    forbinder to noder, da deres next er NULL på denne constructor.

    Node(){

    }

    Node(E data){
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
