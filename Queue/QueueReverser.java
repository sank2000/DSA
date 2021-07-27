package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

import Stack.Stack;

public class QueueReverser {

  public static void reverse(Queue<Integer> queue) {

    Stack stack = new Stack();

    while (!queue.isEmpty()) {
      stack.push(queue.remove());
    }

    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }
  }

  public static void reverse(Queue<Integer> queue,int n) {

    PriorityQueue pq = new PriorityQueue();

    for (int i = 0; i < n; i++) {
      if (queue.isEmpty())
        throw new IllegalArgumentException();
       pq.insert(queue.remove());
    }

    Queue<Integer> queue2 = new ArrayDeque<Integer>();
    while (!pq.isEmpty()) {
      queue2.add(pq.remove());
    }

    while (!queue.isEmpty()) {
      queue2.add(queue.remove());
    }
    
    while (!queue2.isEmpty()) {
      queue.add(queue2.remove());
    }
  }
}
