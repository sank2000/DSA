package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

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

  private class NodeEntry {

    private Node node;
    private int priority;

    NodeEntry(Node node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }

  public Path getShortestPath(String from, String to) {
    var fromNode = graph.get(from);
    var toNode = graph.get(to);

    if (toNode == null || fromNode == null)
      throw new IllegalArgumentException();

    HashMap<Node, Integer> distances = new HashMap<Node, Integer>();
    for (var node : graph.values())
      distances.put(node, Integer.MAX_VALUE);
    distances.replace(fromNode, 0);

    HashMap<Node, Node> previousNodes = new HashMap<Node, Node>();

    HashSet<Node> visited = new HashSet<Node>();

    PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    queue.add(new NodeEntry(fromNode, 0));

    while (!queue.isEmpty()) {
      var current = queue.remove().node;
      visited.add(current);

      for (var edge : current.getEdges()) {
        if (visited.contains(edge.to))
          continue;

        var newDistance = distances.get(current) + edge.weight;
        if (newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          previousNodes.put(edge.to, current);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }

    return buildPath(previousNodes, toNode);
  }

  private Path buildPath(HashMap<Node, Node> previousNodes, Node toNode) {

    Stack<Node> stack = new Stack<Node>();
    stack.push(toNode);
    var previous = previousNodes.get(toNode);
    while (previous != null) {
      stack.push(previous);
      previous = previousNodes.get(previous);
    }

    var path = new Path();
    while (!stack.isEmpty())
      path.add(stack.pop().label);

    return path;
  }

  public boolean hasCycle() {
    HashSet<Node> visited = new HashSet<>();

    for (var node : graph.values()) {
      if (!visited.contains(node) && hasCycle(node, null, visited))
        return true;
    }

    return false;
  }

  private boolean hasCycle(Node node, Node parent, HashSet<Node> visited) {
    visited.add(node);

    for (var edge : node.getEdges()) {
      if (edge.to == parent)
        continue;

      if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
        return true;
    }

    return false;
  }

  public WeightedGraph getMinimumSpanningTree() {
    var tree = new WeightedGraph();

    if (graph.isEmpty())
      return tree;

    PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    var startNode = graph.values().iterator().next();
    edges.addAll(startNode.getEdges());
    tree.addNode(startNode.label);

    if (edges.isEmpty())
      return tree;

    while (tree.graph.size() < graph.size()) {
      var minEdge = edges.remove();
      var nextNode = minEdge.to;

      if (tree.containsNode(nextNode.label))
        continue;

      tree.addNode(nextNode.label);
      tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

      for (var edge : nextNode.getEdges())
        if (!tree.containsNode(edge.to.label))
          edges.add(edge);
    }

    return tree;
  }

  public boolean containsNode(String label) {
    return graph.containsKey(label);
  }
}