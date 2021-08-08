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

    setHeight(root);

    root = balance(root);

    return root;
  }

  private Node balance(Node root) {
    if (isLeftHeavy(root)) {
      if (balanceFactor(root.leftChild) < 0) {
        root.leftChild = leftRotation(root.leftChild);
      }
      root = rightRotation(root);
    } else if (isRightHeavy(root)) {
      if (balanceFactor(root.rightChild) > 0) {
        root.rightChild = rightRotation(root.rightChild);
      }
      root = leftRotation(root);
    }
    return root;
  }

  private int height(Node root) {
    return root == null ? -1 : root.height;
  }

  public void traverseInOrder() {
    traverseInOrder(root);
    System.out.println();
  }

  private Node leftRotation(Node root) {
    var newNode = root.rightChild;

    root.rightChild = newNode.leftChild;
    setHeight(root);

    newNode.leftChild = root;
    setHeight(newNode);

    return newNode;
  }

  private Node rightRotation(Node root) {
    var newNode = root.leftChild;

    root.leftChild = newNode.rightChild;
    setHeight(root);

    newNode.rightChild = root;
    setHeight(newNode);

    return newNode;
  }

  private void traverseInOrder(Node root) {
    if (root == null) {
      return;
    }

    traverseInOrder(root.leftChild);
    System.out.print(root.value);
    traverseInOrder(root.rightChild);
  }

  private void setHeight(Node node) {
    node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
  }

  private int balanceFactor(Node root) {
    return (root == null) ? 0 : height(root.leftChild) - height(root.rightChild);
  }

  private boolean isLeftHeavy(Node root) {
    return balanceFactor(root) > 1;
  }

  private boolean isRightHeavy(Node root) {
    return balanceFactor(root) < -1;
  }
}
