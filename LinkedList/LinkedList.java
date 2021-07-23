package LinkedList;

public class LinkedList {
  private Node head;
  private Node tail;

  public void addFirst(int value) {
    if (isEmpty()) {
      Node newNode = new Node(value, null);
      head = tail = newNode;
      return;
    }
    Node newNode = new Node(value, head);
    head = newNode;
  }

  public void addLast(int value) {
    var newNode = new Node(value, null);
    if (isEmpty()) {
      head = tail = newNode;
      return;
    }
    tail.setNext(newNode);
    tail = newNode;
  }

  public void deleteFirst() {
    if (isEmpty())
      return;
    if (head.getNext() == null) {
      head = tail = null;
    } else {
      var second = head.getNext();
      head.setNext(null);
      head = second;
    }
  }

  public void deleteLast() {
    if (isEmpty())
      return;

    if (head == tail) {
      head = tail = null;
      return;
    }

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
  
  private boolean isEmpty(){
    return head == null;
  }

}
