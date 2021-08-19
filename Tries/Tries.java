package Tries;

public class Tries {

  private class Node {
    Character value;
    Node[] children = new Node[26];
    boolean isEndOfWorld;

    Node(Character ch) {
      this.value = ch;
    }

    Node(Character ch, boolean flag) {
      this.value = ch;
      this.isEndOfWorld = flag;
    }

    @Override
    public String toString() {
      return this.value + " ";
    }
  }

  private Node root = new Node(null);

  public void insert(String str) {
    Node itr = root;
    for (int i = 0; i < str.length(); i++) {
      int ind = index(str.charAt(i));

      if (itr.children[ind] == null) {
        if (i == str.length() - 1) {
          itr.children[ind] = new Node(str.charAt(i), i == str.length() - 1);
          return;
        } else {
          itr.children[ind] = new Node(str.charAt(i));
        }
      }

      itr = itr.children[ind];
    }
  }

  private int index(Character ch) {
    return ch - 'a';
  }

}
