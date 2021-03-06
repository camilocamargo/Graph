package AuxiliarClasses;


/**
 *
 * @author Camilo
 */
public class Node {

    public int value;

    public Node next;

    public Node() {}
    
    public Node(int value) {
        this.value = value;
    }
    
    public String toString(){
        return "Value: " + this.value + "\n"; 
    }

    public Node clone() {
        Node clone = new Node(this.value);
        return clone;
    }
    
}
