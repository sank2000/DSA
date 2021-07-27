package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueue {
  Queue<Integer> queue1 = new ArrayDeque<Integer>();
  Queue<Integer> queue2 = new ArrayDeque<Integer>();
  int top;

  public void push(int item) {
    queue1.add(item);
    top = item;
  }

    public int pop() {
      if (isEmpty())
          throw new IllegalStateException();

      while (queue1.size() > 1) {
          top = queue1.remove();
          queue2.add(top);
      }

      swapQueues();

      return queue2.remove();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

  public int peek() {
    if (isEmpty())
      throw new IllegalStateException();

    return top;
  }

  public boolean isEmpty() {
    return queue1.isEmpty();
  }
}

//  1 2 3 4 5
//  6 7
//  1 2 3 4 5 