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

    while (itr != null) {
      if (itr.value > val) {
        itr = itr.rightChild;
      } else {
        itr = itr.leftChild;
      }
    }

    root = new Node(val);
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

}
