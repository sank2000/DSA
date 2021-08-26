package Graph;

public class Main {

  public static void main(String[] args) {
    Graph gh = new Graph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addNode("D");
    gh.addEdge("A", "B");
    gh.addEdge("A", "C");
    gh.addEdge("B", "D");
    gh.addEdge("D", "C");
    gh.print();
    // gh.depthFirstTraversalRecursive("A");
    gh.breathFirstTraversalIterative("A");
  }

}
