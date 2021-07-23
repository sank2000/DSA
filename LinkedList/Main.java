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

    System.out.println(ls.indexOf(5));

    ls.printList();

    System.out.println(ls.contains(4));

    ls.deleteFirst();
    ls.printList();

    System.out.println(ls.contains(4));

    ls.deleteLast();
    ls.printList();
  }
}
