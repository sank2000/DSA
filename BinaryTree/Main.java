package BinaryTree;

public class Main {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();

    System.out.println(bt.find(10));

    bt.insert(7);
    bt.insert(4);
    bt.insert(9);
    bt.insert(1);
    bt.insert(6);
    bt.insert(8);
    bt.insert(10);
    bt.insert(11);

    System.out.println(bt.find(15));
    System.out.println("------------");

    bt.traversePostOrder();
    bt.traverseInOrder();
    bt.traversePreOrder();

    System.out.println(bt.height());
    System.out.println(bt.min());

    BinaryTree bt2 = new BinaryTree();

    System.out.println(bt.find(10));

    bt2.insert(7);
    bt2.insert(4);
    bt2.insert(9);
    bt2.insert(1);
    bt2.insert(6);
    bt2.insert(8);
    bt2.insert(10);
    bt2.insert(11);

    System.out.print("Comparison: ");

    System.out.println(bt.equals(bt2));
  }
}
