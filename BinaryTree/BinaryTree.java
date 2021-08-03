package BinaryTree;

public class BinaryTree {
  
  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    Node(int val) {
      value = val;
    }
  }

  private Node root;


  public void insert(int val) {
    Node itr = root;
    var node = new Node(val);

    if (itr == null) {
      root = node;
      return;                                                          
    }

    while (true) {
      if (itr.value < val) {
        if (itr.rightChild == null) {
          itr.rightChild = node;
          break;
        }
        itr = itr.rightChild;
      } else {
        if (itr.leftChild == null) {
          itr.leftChild = node;
          break;
        }
        itr = itr.leftChild;
      }
    }
  }


  public boolean find(int val) {
    Node itr = root;

    while (itr != null) {
      if (itr.value == val)
        return true;
      if (itr.value > val) {
        itr = itr.rightChild;
      } else {
        itr = itr.leftChild;
      }
    }

    return false;
  }

  public void traversePreOrder() {
    traversePreOrder(root);
    System.out.println();
  }

  public void traverseInOrder() {
    traverseInOrder(root);
    System.out.println();
  }

  public void traversePostOrder() {
    traversePostOrder(root);
    System.out.println();
  }

  private void traversePreOrder(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.value);
    traversePreOrder(root.leftChild);
    traversePreOrder(root.rightChild);
  }
  
  private void traverseInOrder(Node root) {
    if (root == null) {
      return;
    }

    traverseInOrder(root.leftChild);
    System.out.print(root.value);
    traverseInOrder(root.rightChild);
  }
  
  private void traversePostOrder(Node root) {
    if (root == null) {
      return;
    }

    traversePostOrder(root.leftChild);
    traversePostOrder(root.rightChild);
    System.out.print(root.value);
  }

  public int height() {
    return height(root);
  }

  private int height(Node root) {
    if (root == null)
      return -1;

    if (isLeafNode(root)) {
      return 0;
    }

    return 1 + Math.max(height(root.leftChild), height(root.rightChild));
  }

  public int min() {
    if (root == null)
      return -1;
    return min(root);
  }

  public boolean equals(BinaryTree tree2) {
    if (tree2 == null) {
      throw new IllegalStateException();
    }
    return equals(root,tree2.root);
  }

  public boolean equals(Node root, Node root2) {
    if (root == null && root2 == null)
      return true;

    if (root == null || root2 ==  null) {
      return false;
    }

    if (root.value != root2.value)
      return false;
    var left = equals(root.leftChild,root2.leftChild);
    var right = equals(root.rightChild, root2.rightChild);
    return left && right;
  }

  private int min(Node root) {
    if (root == null)
      return Integer.MAX_VALUE;

    if (isLeafNode(root)) {
      return root.value;
    }

    var left = min(root.leftChild);
    var right = min(root.rightChild);

    return Math.min(Math.min(left, right),root.value);
  }

  private boolean isLeafNode(Node root) {
    return root.leftChild == null && root.rightChild == null;
  };

}
