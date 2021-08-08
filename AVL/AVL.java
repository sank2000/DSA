package AVL;

public class AVL {

  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;
    private int height;

    Node(int val) {
      value = val;
    }

    @Override
    public String toString() {
      return "value :" + value;
    }
  }

  private Node root;

  public void insert(int val) {
    root = insert(root, val);
  }

  private Node insert(Node root, int val) {
    if (root == null) {
      return new Node(val);
    }

    if (root.value < val) {
      root.rightChild = insert(root.rightChild, val);
    } else {
      root.leftChild = insert(root.leftChild, val);
    }
    root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));
    return root;
  }

  private int height(Node root) {
    return root == null ? -1 : root.height;
  }

  public void traverseInOrder() {
    traverseInOrder(root);
    System.out.println();
  }

  private void traverseInOrder(Node root) {
    if (root == null) {
      return;
    }

    traverseInOrder(root.leftChild);
    System.out.print(root.value);
    traverseInOrder(root.rightChild);
  }
}
