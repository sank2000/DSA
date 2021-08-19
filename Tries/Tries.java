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

    @Override
    public String toString() {
      return this.value + " ";
    }
  }

  private Node root = new Node(null);

  public void insert(String str) {
    Node itr = root;

    for (Character ch : str.toCharArray()) {
      if (itr.children.get(ch) == null)
        itr.children.put(ch, new Node(ch));

      itr = itr.children.get(ch);
    }

    itr.isEndOfWorld = true;
  }

}
