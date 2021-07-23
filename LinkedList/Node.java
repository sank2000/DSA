package LinkedList;

public class Node {
  private int value;
  private Node next;

  Node(int val,Node nxt) {
    value = val;
    next = nxt;    
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setValue(int val) {
    value = val;
  }

  public void setNext(Node nxt) {
    next = nxt;
  }
  
}
