package Queue;

// import java.util.ArrayDeque;
// import java.util.Queue;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    // StackQueue queue = new StackQueue();
    // queue.enqueue(1);
    // queue.enqueue(2);
    // queue.enqueue(3);
    // queue.enqueue(4);
    // queue.enqueue(5);

    // System.out.println(queue.dequeue());

    // queue.enqueue(6);

    // System.out.println(queue.dequeue());

    //  ------------------------------------------------

    PriorityQueue pq = new PriorityQueue();
    pq.insert(4);
    pq.insert(2);
    pq.insert(1);
    pq.insert(3);
    pq.insert(5);

    System.out.println(pq);

    System.out.println(pq.remove());
    System.out.println(pq);
  }
}