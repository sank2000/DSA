package Queue;

// import java.util.ArrayDeque;
// import java.util.Queue;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    StackQueue queue = new StackQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    System.out.println(queue.dequeue());

    queue.enqueue(6);

    System.out.println(queue.dequeue());
  }
}