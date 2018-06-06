package AuxiliarClasses;

/*
 * class queue

/**
 *
 * @author Camilo Camargo
 */

public class Queue {

    Node head = null;

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public void enqueue(Node newNode) {
        if(isEmpty()){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Node dequeue() {
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    
    public int front(){
        return head.value;
    }

}
