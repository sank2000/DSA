package Heap;

public class MinPriorityQueue {

  MinHeap hp = new MinHeap();

  public void add(String str, int p) {
    hp.insert(p, str);
  }

  public String remove() {
    return hp.remove().toString();
  }

  public boolean isEmpty() {
    return hp.isEmpty();
  }

  public static void main(String[] args) {
    MinPriorityQueue mpq = new MinPriorityQueue();
    System.out.println(mpq.isEmpty());
    mpq.add("one", 2);
    System.out.println(mpq.isEmpty());
    mpq.add("two", 1);
    System.out.println(mpq.remove());
  }

}
