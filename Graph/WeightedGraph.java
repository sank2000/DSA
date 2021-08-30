package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * WeightedGraph
 */
public class WeightedGraph {

  private class Node {
    private String label;
    ArrayList<Edge> relation = new ArrayList<Edge>();

    Node(String str) {
      label = str;
    }

    public void addRelation(Node to, int weight) {
      relation.add(new Edge(this, to, weight));
    }

    public ArrayList<Edge> getEdges() {
      return relation;
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

  public void addNode(String label) {
    graph.putIfAbsent(label, new Node(label));
  }

  public void addEdge(String from, String to, int weight) {
    Node fromNode = graph.get(from);
    Node toNode = graph.get(to);
    if (fromNode == null || toNode == null)
      throw new IllegalStateException();

    fromNode.addRelation(toNode, weight);
    toNode.addRelation(fromNode, weight);
  }

  public void print() {
    for (Node element : graph.values()) {
      System.out.println(element.label + " ----> " + element.getEdges());
    }
  }

}