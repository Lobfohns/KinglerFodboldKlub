package com.company;

public class LinkedList {

    // EVT LED EFTER MEDLEMMER VED AT PUTTE ALLE DERES ID'ER IND I LISTEN ??? DNU IM TIRED

    Node head;

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null; // default, men læsbart sådan her.

        //Hvis det er den første node (så er head null og vores node bliver til head)
        if (head==null) {
            head = node;
        } else {
            //Vi laver en pointer, som vi kalder n (eller pointer eller w/e passer os)
            Node n = head;

            //så længe n.next ikke er null, så springer vi videre til næste node.
            while(n.next!=null){
                n = n.next;
            }
            n.next = node; //så vi når til sidste node, så bliver dens next til null. den ændrer vi til den nye node.
        }
    }

    public void insertAtStart(int data){

        Node node = new Node();
        node.data=data;
        node.next=null;
        //Hvis vi fjerner forbindelsen mellem head og resten af listen, så forsvinder listen.
        node.next=head;
        head = node;

    }

    public void insertAtIndex(int index, int data){
        Node node = new Node();
        node.data=data;
        node.next=null;

        if (index==0) { // hvis index er 0.. Vi har en metode til det allerede looool
            insertAtStart(data);
        } else {

            Node n = head; // en pointer vi bruger.. Vi rykker frem med for loop.
            for (int i = 0; i < (index - 1); i++) {
                n = n.next;
            }
            node.next = n.next; //Vi sætter vores next INDEN de skifter plads, så listen ikke forsvinder. (garbage collecter)
            n.next = node; // den gamle forbindelse bliver sat på vores nye node.
        }
    }

    public void deleteAt (int index){
        //Vi sletter ved at fjerne forbindelsen til noden og ændrer den prev next-værdi.
        if (index==0){
            head = head.next;
        } else {
            Node n = head; //travel time
            Node n1=null; // noden vi vil slette.
            for (int i = 0; i < (index-1); i++){
                n = n.next;
            }
            n1 = n.next; //Vi vil slette n1. Vi har brug for dens next, for at kunne linke PREV til NEXT..
            n.next = n1.next; //vi sletter n1 ved at fjerne forbindelse.
            n1=null; //garbage collecter incoming

            System.out.println(n1.data + " er blevet slettet.");
        }
    }

    public void deleteLastData(int value){
        if (head.next != null){
            Node n = head; // vores pointer eller current..
            Node spot = null; // bruges til at
            while (n.next != null){
                if (n.next.data == value){ // når den næste boks er value, sættes spot til at være denne boks.
                    spot = n;
                }
                n = n.next; //n rykker vi videre... fortsætter indtil listen er slut
            }
            // når n er rykket igennem den hele:
            if (spot != null){ // kontrol af null?
                spot.next = spot.next.next; // Vi springer value over, og fjerner dens forbindelse.

            } else if (head.data == value){ //Hvis den første værdi er value.. Forstår ikke helt.
                head = head.next;
            }
        }
    }

    public Node nodeAt(int index){
        Node n = head; // vores peger eller CURRENT...
        for (int i = 0; i<index;i++) {
            n = n.next;
        }
        return n;
    }

    // FORLÆNGET med en getter ved index..
    public int getAtIndex(int index) {
        return nodeAt(index).data;
    }

    //returnerer indexet på første gang en værdi findes i listen.. dnu hvorfor den er her.
    public int indexOfFirstAppearance(int value){
        int index=0;
        Node n = head; // n eller CURRENT...
        while (n.next != null){
            if (n.data == value) {
                return index;
            }
            index++;
            n = n.next;
        }
        return -1;
    }

    public void show(){
        Node node = head;
        while (node.next != null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data); // tager den sidste med, da den sidste node har en NULL værdi..
    }

    // Returnerer antal elementer i liste.
    public int countOfElements(){
        int count =0;
        Node n = head;
        while (n != null){
            n=n.next;
            count++;
        }

    return count;
    }

    public String toString(){
        if (head == null){
            return "[]";
        } else {
            String result = "[" + head.data;
            Node n = head.next;
            while (n != null){
                result += ", " + n.data;
                n = n.next;
            }
            return result;
            }
    }


}
