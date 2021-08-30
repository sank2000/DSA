package Graph;

public class Main {

  public static void main(String[] args) {
    WeightedGraph gh = new WeightedGraph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addEdge("A", "B", 5);
    gh.addEdge("A", "C", 3);
    gh.print();
  }

}
