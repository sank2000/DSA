package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

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

  public boolean hasCycle() {
    HashSet<Node> all = new HashSet<Node>();
    HashSet<Node> visiting = new HashSet<Node>();
    HashSet<Node> visited = new HashSet<Node>();

    all.addAll(table.values());

    while (!all.isEmpty()) {
      Node current = (Node) all.toArray()[0];
      if (hasCycle(current, all, visiting, visited))
        return true;
    }

    return false;
  }

  private boolean hasCycle(Node root, HashSet<Node> all, HashSet<Node> visiting, HashSet<Node> visited) {
    visiting.add(root);
    all.remove(root);

    for (Node itr : root.ls) {
      if (visited.contains(itr))
        continue;

      if (visiting.contains(itr))
        return true;

      if (hasCycle(itr, all, visiting, visited))
        return true;
    }

    visiting.remove(root);
    visited.add(root);
    return false;
  }

  public ArrayList<String> topologicalSort(String str) {

    Stack<String> stack = new Stack<String>();
    ArrayList<String> ls = new ArrayList<String>();

    topologicalSort(table.get(str), new HashSet<String>(), stack);

    while (!stack.empty()) {
      ls.add(stack.pop());
    }

    return ls;
  }

  private void topologicalSort(Node root, HashSet<String> set, Stack<String> stack) {
    if (root == null || set.contains(root.label))
      return;

    for (Node itr : root.ls) {
      topologicalSort(itr, set, stack);
    }

    stack.push(root.label);
    set.add(root.label);
  }

  public void depthFirstTraversalRecursive(String str) {
    HashSet<String> set = new HashSet<String>();
    depthFirstTraversalRecursive(table.get(str), set);
  }

  private void depthFirstTraversalRecursive(Node root, HashSet<String> set) {
    if (root == null)
      return;

    if (!set.contains(root.label)) {
      set.add(root.label);
      System.out.println(root.label);
    }

    for (Node itr : root.ls) {
      depthFirstTraversalRecursive(itr, set);
    }
  }

  public void depthFirstTraversalIterative(String str) {
    Node root = table.get(str);

    if (root == null)
      return;

    HashSet<String> visited = new HashSet<String>();
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node curNode = stack.pop();
      if (!visited.contains(curNode.label)) {
        visited.add(curNode.label);
        System.out.println(curNode.label);
      }

      for (Node itr : curNode.ls) {
        if (!visited.contains(itr.label)) {
          stack.push(itr);
        }
      }
    }

  }

  public void breathFirstTraversalIterative(String str) {
    Node root = table.get(str);

    if (root == null)
      return;

    HashSet<String> visited = new HashSet<String>();
    Queue<Node> queue = new ArrayDeque<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curNode = queue.remove();
      if (!visited.contains(curNode.label)) {
        visited.add(curNode.label);
        System.out.println(curNode.label);
      }

      for (Node itr : curNode.ls) {
        if (!visited.contains(itr.label)) {
          queue.add(itr);
        }
      }
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
