package Stack;

public class MinStack {
  private int SIZE = 5;
  private Stack stack;
  private Stack min;

  MinStack(int size) {
    SIZE = size;
    stack = new Stack(size);
    min = new Stack(size);
  }

  MinStack() {
    stack = new Stack(SIZE);
    min = new Stack(SIZE);
  }

  public void push(int value) {
    if (min.isEmpty()) {
      min.push(value);
    } else if (min.peek() > value) {
      min.push(value);
    }
    
    stack.push(value);
  }


  public int pop() {
    if (stack.isEmpty()) {
      throw new IllegalStateException();
    }

    if (min.peek() == stack.peek()) {
      min.pop();
    }

    return stack.pop();
  }

  public int min() {
    return min.peek();
  }

  @Override
  public String toString() {
    return stack.toString();
  }

}
