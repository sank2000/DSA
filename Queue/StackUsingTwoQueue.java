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

    return swapAndRemove();
  }

  private int swapAndRemove() {
     int secondTop = top;
     while (queue1.peek() != top){
       var temp = queue1.remove();
       secondTop = temp;
       queue2.add(temp);
     }
     var value = queue1.remove();
     top = secondTop;
      while (!queue2.isEmpty())
        queue1.add(queue2.remove());
      return value;
  }

  public int peek() {
    if (isEmpty())
      throw new IllegalStateException();

    return top;
  }

  public boolean isEmpty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }
}

//  1 2 3 4 5
//  6 7
//  1 2 3 4 5 