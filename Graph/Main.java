package Graph;

public class Main {

  public static void main(String[] args) {
    Graph gh = new Graph();
    gh.addNode("san");
    gh.addNode("dev");
    gh.addNode("dev2");
    gh.addNode("dev3");
    gh.addEdge("san", "dev");
    gh.removeNode("dev");
    gh.print();
  }

}
