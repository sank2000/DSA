package Tries;

import java.util.HashMap;

public class Tries {

  private class Node {
    private Character value;
    private HashMap<Character, Node> children = new HashMap<Character, Node>();
    private boolean isEndOfWorld;

    Node(Character ch) {
      this.value = ch;
    }

    public boolean hasChildren(Character ch) {
      return this.children.containsKey(ch);
    }

    public void addChild(Character ch) {
      this.children.put(ch, new Node(ch));
    }

    public Node getChild(Character ch) {
      return this.children.get(ch);
    }

    public Node[] getChildren() {
      return this.children.values().toArray(new Node[0]);
    }

    @Override
    public String toString() {
      return this.value + " ";
    }
  }

  private Node root = new Node(null);

  public void insert(String str) {
    Node itr = root;

    for (Character ch : str.toCharArray()) {
      if (!itr.hasChildren(ch))
        itr.addChild(ch);
      itr = itr.getChild(ch);
    }

    itr.isEndOfWorld = true;
  }

  public boolean contains(String str) {
    if (str == null)
      throw new IllegalStateException();

    Node itr = root;
    for (int i = 0; i < str.length(); i++) {
      Character ch = str.charAt(i);
      if (itr.hasChildren(ch)) {
        if (itr.getChild(ch).isEndOfWorld && i == str.length() - 1)
          return true;
        itr = itr.getChild(ch);
      } else {
        return false;
      }
    }

    return false;
  }

  public void traverse() {
    traverse(root);
  }

  private void traverse(Node root) {
    if (root == null)
      return;
    System.out.println(root.value);

    for (Node itr : root.getChildren()) {
      traverse(itr);
    }
  }

}
