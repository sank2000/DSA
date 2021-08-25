package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph {

  private class Node {
    private String label;
    private ArrayList<Node> ls = new ArrayList<Node>();

    Node(String str) {
      label = str;
    }

    public void addRelation(Node nd) {
      if (ls.contains(nd))
        return;
      ls.add(nd);
    }

    public void removeRelation(Node nd) {
      ls.remove(nd);
    }

    private String getRelations() {
      String[] temp = new String[ls.size()];
      int i = 0;
      for (Node nd : ls) {
        temp[i++] = nd.label;
      }
      return i == 0 ? "None" : Arrays.toString(temp);
    }

    @Override
    public String toString() {
      return label + " is connected to " + getRelations();
    }

  }

  private HashMap<String, Node> table = new HashMap<String, Node>();

  public void addNode(String label) {
    table.putIfAbsent(label, new Node(label));
  }

  public void removeNode(String label) {
    Node removed = table.remove(label);
    if (removed == null)
      throw new IllegalStateException();

    for (Node itr : table.values()) {
      itr.removeRelation(removed);
    }
  }

  public void addEdge(String from, String to) {
    Node fromNode = table.get(from);
    Node toNode = table.get(to);
    if (fromNode == null || toNode == null)
      throw new IllegalStateException();

    fromNode.addRelation(toNode);
  }

  public void removeEdge(String from, String to) {
    Node fromNode = table.get(from);
    Node toNode = table.get(to);
    if (fromNode == null || toNode == null)
      return;

    fromNode.removeRelation(toNode);
  }

  public void print() {
    for (Node itr : table.values()) {
      System.out.println(itr);
    }
  }

}
