package AuxiliarClasses;

/*
 * Class stack
 */

/**
 *
 * @author Camilo Camargo
 */
public class Stack {

    Node head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }

    public void push(Node newNode) {
        if(isEmpty()){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    public Node pop() {
        if (!isEmpty()) {
            Node temp = head;
            head = head.next;
            temp = null;
            return temp;
        }
        return null;
    }
}
