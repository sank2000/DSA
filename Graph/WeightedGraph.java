package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * WeightedGraph
 */
public class WeightedGraph {

  private class Node {
    private String label;

    Node(String str) {
      label = str;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  private class Edge {
    private Node from;
    private Node to;
    private int weight;

    Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return from + " -> " + to + " { " + weight + " } ";
    }
  }

  private HashMap<String, Node> graph = new HashMap<String, Node>();
  private HashMap<Node, ArrayList<Edge>> relation = new HashMap<Node, ArrayList<Edge>>();

  public void addNode(String label) {
    var node = new Node(label);
    graph.putIfAbsent(label, node);
    relation.putIfAbsent(node, new ArrayList<Edge>());
  }

  public void addEdge(String from, String to, int weight) {
    Node fromNode = graph.get(from);
    Node toNode = graph.get(to);
    if (fromNode == null || toNode == null)
      throw new IllegalStateException();

    relation.get(fromNode).add(new Edge(fromNode, toNode, weight));
    relation.get(toNode).add(new Edge(toNode, fromNode, weight));
  }

  public void print() {
    for (ArrayList<Edge> itr : relation.values()) {
      System.out.println(itr.get(0).from + " ----> " + itr);
    }
  }

}