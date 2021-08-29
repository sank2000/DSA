package Graph;

public class Main {

  public static void main(String[] args) {
    Graph gh = new Graph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addEdge("A", "B");
    gh.addEdge("B", "C");
    gh.addEdge("C", "A");
    gh.print();
    System.out.println(gh.hasCycle());
    // System.out.println(gh.topologicalSort("X"));
    // gh.depthFirstTraversalRecursive("A");
    // gh.breathFirstTraversalIterative("A");
  }

}
