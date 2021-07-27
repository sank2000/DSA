package Queue;

import java.util.Arrays;

public class PriorityQueue {
  private int[] arr;
  private int SIZE = 5;

  private int length = 0;

  PriorityQueue(int size) {
    arr = new int[size];
    SIZE = size;
  }

  PriorityQueue() {
    arr = new int[SIZE];
  }

  public void insert(int value) {
    if (isFull()) {
      throw new IllegalStateException();
    }

    if (length == 0) {
      arr[length++] = value;
      return;
    }

    boolean flag = false;

    for (int i = length - 1; i >= 0; i--) {
      if (arr[i] > value) {
        arr[i + 1] = arr[i];
      } else {
        arr[i + 1] = value;
        flag = true;
        break;
      }
    }

    if (!flag) {
      arr[0] = value;
    }

    length++;

  }
  
  public int remove() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    int value = arr[0];
    for (int ind = 1; ind < length; ind++) {
      arr[ind - 1] = arr[ind];
    }
    length--;
    return value;
  }
  
  public boolean isFull() {
    return length == SIZE;
  }

  public boolean isEmpty() {
    return length == 0;
  }
  
  @Override
  public String toString() {
    var content = Arrays.copyOfRange(arr, 0, length);
    return Arrays.toString(content);
  }
}
