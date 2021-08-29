package Graph;

public class Main {

  public static void main(String[] args) {
    Graph gh = new Graph();
    gh.addNode("X");
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("P");
    gh.addEdge("X", "A");
    gh.addEdge("X", "B");
    gh.addEdge("A", "P");
    gh.addEdge("B", "P");
    gh.print();
    System.out.println(gh.topologicalSort("X"));
    // gh.depthFirstTraversalRecursive("A");
    // gh.breathFirstTraversalIterative("A");
  }

}
