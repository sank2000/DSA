package Stack;

import java.util.Arrays;

public class Stack {
  private int SIZE = 5;
  private int COUNT = 0;
  private int[] arr;

  Stack(int size) {
    SIZE = size;
    arr = new int[size];
  }

  Stack() {
    arr = new int[SIZE];
  }

  public void push(int value) {
    if (COUNT == SIZE) {
      throw new StackOverflowError();
    }

    arr[COUNT++] = value;
  }


  public int pop() {
    if (COUNT == 0) {
      throw new IllegalStateException();
    }

    return arr[--COUNT];
  }

  public int peek() {
    if (COUNT == 0) {
      throw new IllegalStateException();
    }

    return arr[COUNT - 1];
  }

  @Override
  public String toString() {
    var content = Arrays.copyOfRange(arr, 0, COUNT);
    return Arrays.toString(content);
  }

  public boolean isEmpty() {
    return COUNT == 0;
  }
}