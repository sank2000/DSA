package Graph;

public class Main {

  public static void main(String[] args) {
    WeightedGraph gh = new WeightedGraph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addEdge("A", "B", 1);
    gh.addEdge("B", "C", 2);
    gh.addEdge("C", "A", 10);
    gh.print();
    System.out.println(gh.hasCycle());
  }

}
