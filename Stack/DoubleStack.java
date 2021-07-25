package Stack;

import java.util.Arrays;

public class DoubleStack {
  private int SIZE = 5;
  private int first = 0;
  private int second;
  private int[] arr;

  DoubleStack(int size) {
    if (size <= 0)
      throw new IllegalArgumentException("size must be 1 or greater.");

    SIZE = size;
    arr = new int[size];
    first = size - 1;
  }

  DoubleStack() {
    arr = new int[SIZE];
    second = SIZE - 1;
  }

  public void push1(int value) {
    if (checkEqual()) {
      throw new StackOverflowError();
    }

    arr[first++] = value;
  }

  public void push2(int value) {
    if (checkEqual()) {
      throw new StackOverflowError();
    }

    arr[second--] = value;
  }


  public int pop1() {
    if (first == 0) {
      throw new IllegalStateException();
    }

    return arr[--first];
  }

  public int pop2() {
    if (second == SIZE -1) {
      throw new IllegalStateException();
    }

    return arr[++second];
  }

  @Override
  public String toString() {
    var content1 = Arrays.copyOfRange(arr, 0, first);
    var content2 = Arrays.copyOfRange(arr, second + 1, SIZE);
    return  "First :" + Arrays.toString(content1)+ " Second :" + Arrays.toString(content2);
  }

  public boolean isEmpty1() {
    return first == 0;
  }

  public boolean isEmpty2() {
    return second == SIZE - 1;
  }
  
  public boolean isFull1() {
    return checkEqual();
  }

  public boolean isFull2() {
    return checkEqual();
  }

  private boolean checkEqual() {
    return first == second + 1; 
  }
}
