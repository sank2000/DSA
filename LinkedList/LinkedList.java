package LinkedList;

public class LinkedList {
  private Node head;
  private Node tail;
  private int SIZE = 0;

  public void addFirst(int value) {
    if (isEmpty()) {
      var newNode = new Node(value, null);
      head = tail = newNode;
    } else {
      Node newNode = new Node(value, head);
      head = newNode;
    }
    SIZE++;
  }

  public void addLast(int value) {
    var newNode = new Node(value, null);
    if (isEmpty()) {
      head = tail = newNode;
    }else{
      tail.setNext(newNode);
      tail = newNode;
    }
    SIZE++;
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
    SIZE--;
  }

  public void deleteLast() {
    if (isEmpty())
      return;

    if (head == tail) {
      head = tail = null;
      SIZE--;
      return;
    }

    Node itr = head;
    while (itr.getNext() != tail) {
      itr = itr.getNext();
    }

    itr.setNext(null);
    tail = itr;
    SIZE--;
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

  public int getSize()  {
    return SIZE;
  }
  
  public int[] convertToArray() {
    int[] arr = new int[SIZE];
    Node itr = head;

    int index = 0;
    while (itr != null) {
      arr[index++] = itr.getValue();
      itr = itr.getNext();
    }

    return arr;
  }

  public void reverse() {
    if (head == null)
      return;

    var previous = head;
    var current = head.getNext();

    while (current != null) {
      var next = current.getNext();    
      current.setNext(previous);
      previous = current;
      current = next;
    }

    var temp = tail;
    tail = head;
    head = temp;
    tail.setNext(null);

  }

  public Node getKthNodeFromEnd(int k) {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    Node start = head, end = head;

    for (int i = 0; i < k - 1; i++) {
      if (end.getNext() == null) {
        throw new IllegalArgumentException();
      }
      end = end.getNext();
    }

    while (end.getNext() != null) {
      start = start.getNext();
      end = end.getNext();
    }

    return start;
  }
  
  public void printMiddle() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    Node start = head, end = head;
    while (end != tail && end.getNext() != tail) {
      start = start.getNext();
      end = end.getNext().getNext();
    }
    if (end == tail)
      System.out.println(start.getValue());
    else
      System.out.println(start.getValue() + " , " + start.getNext().getValue());
  }
  
  public void addLoopWithEnd(int node) {
    if (node > SIZE) {
      throw new IllegalStateException();
    }

    Node itr = head;
    for (int i = 1; i < node; i++) {
      itr = itr.getNext();
    }

    tail.setNext(itr);
  }

  public boolean hasLoop() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    Node start = head, end = head;
    while (start != tail && start != null) {
      start = start.getNext();
      end = end.getNext();
      
      if (end == null)
        return false;
      
      end = end.getNext();
      
      if (start == end) {
        return true;
      }
    }

    return false;
  }
  
  private boolean isEmpty(){
    return head == null;
  }
}
