package Queue;

import java.util.Stack;

public class StackQueue {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void enqueue(int value) {
    stack1.push(value);
  }

  public int dequeue() {
    if (isEmpty())
      throw new IllegalStateException();

    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }

    var item = stack2.pop();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    return item;
  }

  public int peek() {
    if (isEmpty())
      throw new IllegalStateException();
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }

    var item = stack2.peek();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    return item;
  }

  public boolean isEmpty() {
    return stack1.empty();
  }

  @Override
  public String toString() {
    return stack1.toString();
  }

}
