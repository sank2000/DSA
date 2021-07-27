package Queue;

import java.util.LinkedList;

public class LinkListQueue {

  LinkedList<Integer> ll = new LinkedList<>();

  public void enqueue(int value) {
    ll.addLast(value);
  }

  public int dequeue() {
    return ll.removeFirst();
  }

  public int peek() {
    var value = ll.peek();
    if (value == null) {
      return -1;
    }
    return value;
  }

  public int size() {
    return ll.size();
  }

  public boolean isEmpty() {
    if (ll.peek() == null) {
      return false;
    }
    return true;
  }
  
  @Override
  public String toString() {
    return ll.toString();
  }
}
