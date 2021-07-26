package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);

    System.out.println(queue);

    QueueReverser.reverse(queue);

    System.out.println(queue);
  }
}