package Queue;

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
  
}
