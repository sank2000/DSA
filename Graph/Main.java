package Graph;

public class Main {

  public static void main(String[] args) {
    WeightedGraph gh = new WeightedGraph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addEdge("A", "B", 1);
    gh.addEdge("B", "C", 2);
    gh.addEdge("A", "C", 10);
    gh.print();
    System.out.println(gh.getShortestPath("A", "C"));
  }

}
