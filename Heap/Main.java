package Heap;

// import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    MinHeap hp = new MinHeap();

    hp.insert(10, "one");
    hp.insert(5, "two");
    hp.insert(17, "three");
    hp.insert(4, "four");
    hp.insert(22, "five");

    System.out.println(hp.remove());
  }

}
