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

}
