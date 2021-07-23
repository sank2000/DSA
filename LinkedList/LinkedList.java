package LinkedList;

public class LinkedList {
  private Node head;
  private Node tail;

  public void addFirst(int value) {
    if (head == null) {
      Node newNode = new Node(value, null);
      head = tail = newNode;
      return;
    }
    Node newNode = new Node(value, head);
    head = newNode;
  }

  public void addLast(int value) {
    if (tail == null) {
      Node newNode = new Node(value, null);
      head = tail = newNode;
      return;
    }
    Node newNode = new Node(value, null);
    tail.setNext(newNode);
    tail = newNode;
  }

  public void deleteFirst() {
    if (head == null)
      return;
    if (head.getNext() == null) {
      head = null;
      tail = null;
    } else {
      head = head.getNext();
    }
  }

  public void deleteLast() {
    if (head == null)
      return;

    Node itr = head;
    while (itr.getNext() != tail) {
      itr = itr.getNext();
    }

    itr.setNext(null);
    tail = itr;
  }

  public void printList() {
    Node itr = head;
    while (itr != null) {
      System.out.print(itr.getValue() + " ");
      itr = itr.getNext();
    }
    System.out.println();
  }

  public boolean contains(int item) {
    Node itr = head;
    while (itr != null) {
      if (itr.getValue() == item)
        return true;
      itr = itr.getNext();
    }
    return false;
  }
  
  public int indexOf(int item){
    Node itr = head;
    int index = 0;
    while(itr != null){
      if(itr.getValue() == item) return index;
      index++;
      itr  = itr.getNext();
    } 
    return -1;
  }
}
