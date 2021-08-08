package AVL;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    AVL avl = new AVL();

    avl.insert(7);
    avl.insert(4);
    avl.insert(9);
    avl.insert(1);
    avl.insert(6);
    avl.insert(8);
    avl.insert(10);

    avl.traverseInOrder();
  }

}