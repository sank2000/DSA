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
  
  public void printList(){
    Node itr = head;
    while(itr != null){
      System.out.print(itr.getValue()+ " ");
      itr = itr.getNext();
    }
    System.out.println();
    
  }
}
