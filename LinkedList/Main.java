package LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList ls = new LinkedList();

    ls.addFirst(1);
    ls.addFirst(2);
    ls.addFirst(3);
    ls.addFirst(4);

    ls.addLast(5);
    ls.addLast(6);
    ls.addLast(7);

    ls.printList();

    ls.deleteFirst();
    ls.printList();

    ls.deleteLast();
    ls.printList();
  }
}
