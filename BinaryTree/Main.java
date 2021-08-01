package BinaryTree;

public class Main {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();

    System.out.println(bt.find(10));

    bt.insert(2);
    System.out.println(bt.find(2));

    bt.insert(5);
    bt.insert(4);
    bt.insert(7);
    bt.insert(1);
    bt.insert(7);
    System.out.println(bt.find(7));
    System.out.println(bt.find(15));
  }
}
