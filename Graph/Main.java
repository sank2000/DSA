package Graph;

public class Main {

  public static void main(String[] args) {
    WeightedGraph gh = new WeightedGraph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addNode("D");
    gh.addEdge("A", "B", 3);
    gh.addEdge("B", "D", 4);
    gh.addEdge("C", "D", 5);
    gh.addEdge("A", "C", 2);
    gh.addEdge("B", "C", 1);
    gh.getMinimumSpanningTree().print();
  }

}
