package Graph;

public class Main {

  public static void main(String[] args) {
    Graph gh = new Graph();
    gh.addNode("A");
    gh.addNode("B");
    gh.addNode("C");
    gh.addEdge("A", "B");
    gh.addEdge("A", "C");
    gh.removeNode("C");
    gh.print();
  }

}
