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

    // PriorityQueue pq = new PriorityQueue();
    // pq.insert(4);
    // pq.insert(2);
    // pq.insert(1);
    // pq.insert(3);
    // pq.insert(5);

    // System.out.println(pq);

    // System.out.println(pq.remove());
    // System.out.println(pq);

    // -------------------------------------

    // Queue<Integer> queue = new ArrayDeque<Integer>();
    // queue.add(5);
    // queue.add(1);
    // queue.add(3);
    // queue.add(7);
    // queue.add(10);

    // System.out.println(queue);

    // QueueReverser.reverse(queue, 3);

    // System.out.println(queue);

    // ------------------------------------------------

    LinkListQueue lq = new LinkListQueue();

    System.out.println(lq.isEmpty());

    lq.enqueue(1);

    System.out.println(lq.isEmpty());

    lq.enqueue(2);
    lq.enqueue(3);
    lq.enqueue(4);

    System.out.println(lq);

    System.out.println(lq.dequeue());

    System.out.println(lq);
  }
}