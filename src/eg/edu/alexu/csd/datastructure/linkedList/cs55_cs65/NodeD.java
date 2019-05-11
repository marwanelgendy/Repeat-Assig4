package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

public class NodeD {
    int value ;
    NodeD next ;
    NodeD previous ;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD getPrevious() {
        return previous;
    }

    public void setPrevious(NodeD previous) {
        this.previous = previous;
    }
}
