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

}
